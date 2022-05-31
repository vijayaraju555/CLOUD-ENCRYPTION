package com.cloudencryption.dao;

import com.cloudencryption.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {
    void addUser(User u) throws Exception;

    boolean checkUser(String email, String password) throws Exception;


    User getUserByEmail(String email) throws Exception;
}

