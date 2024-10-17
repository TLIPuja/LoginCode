package com.example.workflow.controller;

import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import com.example.workflow.services.Service;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ReassignComplaintDelegate")
public class ReassignComplaintDelegate implements JavaDelegate {

    @Autowired
    private Service complaintService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Retrieve variables from the execution context
        String complaintId = (String) execution.getVariable("complaintId");
        String newUserId = (String) execution.getVariable("newUserId"); // New user ID for reassignment
        String userConfirmation = (String) execution.getVariable("userConfirmation"); // Confirmation from user
        Users selectedUser = (Users) complaintService.findUserById(Integer.parseInt(newUserId));

        // Check if the user confirmed they can take on the task
        if ("yes".equalsIgnoreCase(userConfirmation)) {
            // Fetch the complaint using the complaint service
            Complaints complaint = complaintService.getComplaintById(Integer.parseInt(complaintId));
            if (complaint != null && newUserId != null) {
                // Update the complaint status and assignee
                complaint.setStatus("Assigned");
                complaint.setAssignee(selectedUser.getUsername()); // Reassign to the new user
                // Save the updated complaint back to the database
                complaintService.updateComplaint(complaint.getComplaint_id(),complaint.getAssignee());
            }
        } else {
            // Optional: Handle the case where the user did not confirm
            System.out.println("User declined to take on the task.");
        }
    }
}


