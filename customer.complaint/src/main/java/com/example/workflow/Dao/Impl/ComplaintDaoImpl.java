package com.example.workflow.Dao.Impl;

import com.example.workflow.Dao.ComplaintDao;
import com.example.workflow.model.Complaints;
import com.example.workflow.model.Users;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComplaintDaoImpl implements ComplaintDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Complaints> findBystatus(String status){
        String queryStr = "SELECT c FROM Complaints c WHERE c.status = 'Open'";
        TypedQuery<Complaints> query = entityManager.createQuery(queryStr, Complaints.class);
        return query.getResultList();
    }

    @Override
    public void updateComplaintAssignee(Integer complaintId, String userName) {
        // Native SQL or HQL query to update the complaint assignee
        String query = "UPDATE Complaints c SET c.assignee = :userName WHERE c.id = :complaintId";
        entityManager.createQuery(query)
                .setParameter("userName", userName)
                .setParameter("complaintId", complaintId)
                .executeUpdate();
    }
    @Override
   public Complaints findComplaintById(Integer complaintId){

            String query = "SELECT c FROM Complaints c WHERE c.id = :complaintId";
            return entityManager.createQuery(query, Complaints.class)
                    .setParameter("complaintId", complaintId)
                    .getSingleResult();


   }

    @Override
    public boolean userHasOpenComplaints(String username) {
        String jpql = "SELECT COUNT(c) FROM Complaints c WHERE c.assignee = :username AND c.status = 'Open'";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("username",username);
        Long count = (Long) query.getSingleResult();
        System.out.println(count);
        return count > 0;
    }







}




