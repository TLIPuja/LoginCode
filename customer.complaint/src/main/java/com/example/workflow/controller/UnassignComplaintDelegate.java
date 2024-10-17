package com.example.workflow.controller;

import com.example.workflow.model.Complaints;
import com.example.workflow.services.Service;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("unassignComplaintDelegate")
public class UnassignComplaintDelegate implements JavaDelegate {

    @Autowired
    private Service complaintService; // Inject your service to interact with DB

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Retrieve the complaint ID from the process variables
        String complaintId = (String) execution.getVariable("complaintId");

        // Fetch the complaint and update its status to "Unassigned"
        Complaints complaint = complaintService.getComplaintById(Integer.parseInt(complaintId));

        if (complaint != null && "Open".equals(complaint.getStatus())) {

            complaint.setStatus("Unassigned");
            complaintService.updateComplaint(complaint.getComplaint_id(), complaint.getCustomer_name());
            complaint.setAssignee(null);
        }

        // Optionally log the update or store confirmation
        System.out.println("Complaint ID: " + complaintId + " has been unassigned.");
    }
}


