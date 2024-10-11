package com.example.workflow.controller;


import com.example.workflow.model.Users;

import com.example.workflow.services.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("FetchUsersDelegate")
public class FetchUsersDelegate implements JavaDelegate {

    @Autowired
    private Service service;

    @Autowired
    private ObjectMapper objectMapper; // Autowire ObjectMapper to convert objects to JSON
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Fetch all users from the database
        List<Users> users = service.getAllusers();
        try {
            // Convert the list of users to a JSON string
            String usersJson = objectMapper.writeValueAsString(users);
            // Set the JSON string as a process variable in Camunda
            execution.setVariable("userListJson", usersJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to convert user list to JSON");
        }
    }
}
