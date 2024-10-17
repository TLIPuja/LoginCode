package com.example.workflow.services;

import com.example.workflow.Dao.ComplaintDao;
import com.example.workflow.Dao.UserDao;
import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

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
    @Transactional
    public List<Complaints> getAllOpenComplaints() {
        return complaintDao.findBystatus("Open");
        //return dao.findAll();
    }

@Transactional
    public List<Users> getAllusers() {
        return userDao.findAllUsers();
    }
@Transactional
    public Complaints getComplaintById(Integer complaintId) {

            return complaintDao.findComplaintById(complaintId);

        //.orElse(() -> new NoSuchElementException("No complaint found with ID: " + complaintId));
        // return Complaints.getStatus().equalsIgnoreCase("Open");
    }
@Transactional
    public void updateComplaint(Integer complaintId, String userName) {
        //   complaintsDao.save(complaint);

        complaintDao.updateComplaintAssignee(complaintId, userName);

    }
@Transactional
    public Object findUserById(Integer id) {
    return userDao.findUserById(id);
    }
    @Transactional
    public boolean getOpenComplaintsByUserId(String username)  {
         return complaintDao.userHasOpenComplaints(username);
    }

//    public void assignComplaint(int complaintId, int userId) throws Exception {
//        // Check if the user is already assigned to an open complaint
//        boolean isAssigned = complaintDao.userHasOpenComplaints(userId);
//        if (isAssigned) {
//            throw new Exception("User is already assigned to an open complaint.");
//        }
//      return complaintDao.assignComplaintToUser(complaintId,userId);
//
//
//    }
//public void closeComplaint(String complaintId) {
//    // Mark the complaint as closed
//   Complaints complaint = complaintDao.findComplaintById(Integer.valueOf(complaintId));
////    complaint.setStatus("Closed");
////    complaintDao.updateComplaintAssignee(complaint.getComplaint_id(),complaint.getCustomer_name());
//    if ( complaint!= null && "Open".equals(complaint.getStatus())) {
//        // Update the complaint status to "Unassigned"
//        complaint.setStatus("Close");
//        complaint.setAssignee(null); // Clear the assignee
//        complaintService.updateComplaint(complaint.getComplaint_id(), complaint.getCustomer_name());
//       // complaint.setAssignee(null);
//    }
}

