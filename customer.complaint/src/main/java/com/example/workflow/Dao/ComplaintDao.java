package com.example.workflow.Dao;

import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface ComplaintDao {

    public List<Complaints> findBystatus(String status);

   public void updateComplaintAssignee(Integer complaintId, String userName);
   public Complaints findComplaintById(Integer complaintId);

   // boolean userHasOpenComplaints(int userId);


}
