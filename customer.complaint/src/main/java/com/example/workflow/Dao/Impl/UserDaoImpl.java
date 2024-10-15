package com.example.workflow.Dao.Impl;

import com.example.workflow.Dao.UserDao;
import com.example.workflow.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Users> findAllUsers() {
        // Use JPQL to fetch all complaints
        String queryStr = "SELECT c FROM Complaints c";
        TypedQuery<Users> query = entityManager.createQuery(queryStr, Users.class);
        return query.getResultList();
    }
    @Override
    public Users findUserById(Integer id) {

        String query = "SELECT u FROM Users u WHERE u.user_id = :id";
        try {
            return entityManager.createQuery(query, Users.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (RuntimeException e) {
            throw new RuntimeException("User with ID: " + id + " does not exist.");

        }
        //}
    }
}
