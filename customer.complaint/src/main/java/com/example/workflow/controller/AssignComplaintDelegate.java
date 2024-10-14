package com.example.workflow.controller;
import com.example.workflow.model.Complaints;

import com.example.workflow.model.Users;
import com.example.workflow.services.Service;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignComplaintDelegate implements JavaDelegate {

    @Autowired
    private Service service;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Retrieve process variables
//        String selectedUser = (String) execution.getVariable("selectedUser");
//        String selectedComplaintId = (String) execution.getVariable("selectedComplaintId");
//
//        // Fetch the complaint object and update the assignee
//        Complaints complaint = service.getComplaintById(Integer.valueOf(selectedComplaintId));
//        complaint.setAssignee(selectedUser);
//
//        // Update the complaint in the database
//        service.updateComplaint(complaint);
//
//
//        execution.setVariable("assignedComplaint", complaint);
        String  complaintId = (String) execution.getVariable("complaintId");
        String selectedUserId = (String) execution.getVariable("selectedUserId");
        //Complaints complaint = service.getComplaintById(Integer.parseInt("complaintId"));
        //Users selectedUser = service.findUserById(Integer.parseInt("selectedUserId"));
        //Users selectedUser= (Users) service.findUserById(Integer.parseInt("selectedUserId"));
        Complaints complaint = service.getComplaintById(Integer.parseInt(complaintId));
        Users selectedUser = (Users) service.findUserById(Integer.parseInt(selectedUserId));
       // if(complaint.getStatus()=="Open") {
//       if (service.getOpenComplaintsByUserId(Integer.parseInt(selectedUser.getUser_id()))) {
//throw ()
//        }

        if (complaint != null && selectedUser != null &&"Open".equals(complaint.getStatus())) {
           boolean getOpenComplaintsByUserId = service.getOpenComplaintsByUserId(selectedUser.getUsername());
         //  System.out.println("User ID: " + selectedUserId + " is assigned to open complaints: " + getOpenComplaintsByUserId);
            if (getOpenComplaintsByUserId) {
                throw new RuntimeException("User is already assigned to an open complaint and cannot be assigned to another.");
            }

            complaint.setAssignee(selectedUser.getUsername());
               service.updateComplaint(Integer.parseInt(complaintId),
                       selectedUser.getUsername());

               // Set the updated complaint as a process variable in Camunda
               execution.setVariable("updatedComplaint", complaint);
           }
      // }
        else {
            throw new RuntimeException("You can not assign a user for close complaints");
        }
    }
}
