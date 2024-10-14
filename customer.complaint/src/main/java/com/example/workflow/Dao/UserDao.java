package com.example.workflow.Dao;

import com.example.workflow.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<Users> findAllUsers();
    public Users findUserById(Integer id) ;

}
