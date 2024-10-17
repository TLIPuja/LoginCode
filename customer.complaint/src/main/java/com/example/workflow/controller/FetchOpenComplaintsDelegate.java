package com.example.workflow.controller;
import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import com.example.workflow.services.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("FetchOpenComplaintsDelegate")
public class FetchOpenComplaintsDelegate implements JavaDelegate {
    @Autowired
   // private Dao complaintRepository;
private Service service;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Complaints> openComplaints = service.getAllOpenComplaints();
        String Listjson =objectMapper.writeValueAsString(openComplaints);

//        List<String> complaintDescriptions = openComplaints.stream()
//                .map(c -> "ID: " + c.getComplaint_id() + "Name: " + c.getCustomer_name() + "Email: " + c.getCustomer_email() + "Description: " + c.getComplaint_description() + "Type: " + c.getComplaint_type() + "Status: " + c.getStatus() + "Priority: " + c.getPriority()+"\n")
//                .collect(Collectors.toList());
       execution.setVariable("openComplaints", Listjson);
            // Fetch all users from the database
            List<Users> users = service.getAllusers();
          //  try {
                String usersJson = objectMapper.writeValueAsString(users);
                execution.setVariable("userListJson", usersJson);
           // } catch (JsonProcessingException e) {
             //   e.printStackTrace();
             //   throw new RuntimeException("Failed to convert user list to JSON");
            }


    }


//    public void execute(DelegateExecution execution) throws Exception {
//        List<Complaints> openComplaints = service.getAllOpenComplaints();
//
//        // Convert each Complaint to a formatted String with new lines
//        List<String> complaintDescriptions = openComplaints.stream()
//                .map(c -> "ID: " + c.getComplaint_id() + "\n" +
//                        "Name: " + c.getCustomer_name() + "\n" +
//                        "Email: " + c.getCustomer_email() + "\n" +
//                        "Description: " + c.getComplaint_description() + "\n" +
//                        "Type: " + c.getComplaint_type() + "\n" +
//                        "Status: " + c.getStatus() + "\n" +
//                        "Priority: " + c.getPriority() + "\n")
//                .collect(Collectors.toList());
//
//        // Set the variable in Camunda with the formatted list
//        execution.setVariable("openComplaints", complaintDescriptions);
//    }




