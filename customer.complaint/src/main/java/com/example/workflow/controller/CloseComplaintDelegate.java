package com.example.workflow.controller;

import com.example.workflow.model.Complaints;
import com.example.workflow.services.Service;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CloseComplaintDelegate")
public class CloseComplaintDelegate implements JavaDelegate {

    @Autowired
    private Service complaintService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String complaintId = (String) execution.getVariable("complaintId");

        // Mark complaint as closed
        // complaintService.closeComplaint(complaintId);
        Complaints complaint = complaintService.getComplaintById(Integer.parseInt(complaintId));
        String complaintStatus = (String) execution.getVariable("complaintStatus");
        boolean closeCondition = "close".equalsIgnoreCase(complaintStatus);

        if (complaint != null && "Open".equals(complaint.getStatus())) {
            // Update the complaint status to "Unassigned"
            complaint.setStatus("Close");
            complaintService.updateComplaint(complaint.getComplaint_id(), complaint.getCustomer_name());
            complaint.setAssignee(null); // Clear the assignee
        }
        execution.setVariable("closeCondition", closeCondition);

        // complaint.setAssignee(null); // Clear the assignee
        // complaintService.updateComplaint(complaint.getComplaint_id(), complaint.getCustomer_name());
        // complaint.setAssignee(null); // Clear the assignee




    }
}


