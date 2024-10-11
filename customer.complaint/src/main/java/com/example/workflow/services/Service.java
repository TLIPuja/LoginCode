package com.example.workflow.services;

import com.example.workflow.Dao.ComplaintDao;
import com.example.workflow.Dao.UserDao;
import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
       @Autowired
     private ComplaintDao complaintDao;
@Autowired
private UserDao userDao;
////    public List<Complaints> getAllComplaints() {
//        return dao.findAll();
//    }
//
//    public Complaints getComplaintById(Long id) {
//        return dao.findById(id).orElse(null);
//    }
public List<Complaints> getAllOpenComplaints() {
    return complaintDao.findBystatus("Open");
    //return dao.findAll();
}


public List<Users> getAllusers(){
    return userDao.findAllUsers();
}

    public Complaints getComplaintById(Integer complaintId) {
        return complaintDao.findComplaintById(complaintId);
               // .orElseThrow(() -> new NoSuchElementException("No complaint found with ID: " + complaintId));
       // return Complaints.getStatus().equalsIgnoreCase("Open");
    }
    public void updateComplaint(Integer complaintId, String userName) {
     //   complaintsDao.save(complaint);
        complaintDao.updateComplaintAssignee(complaintId, userName);

    }
    public Object findUserById(Integer id) {

    return userDao.findUserById(id).orElse(null);
    }

    public boolean getOpenComplaintsByUserId(int userId) {
        return complaintDao.userHasOpenComplaints(userId);
    }

}
