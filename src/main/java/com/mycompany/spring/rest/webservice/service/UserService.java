package com.mycompany.spring.rest.webservice.service;

import java.util.List;

import com.mycompany.spring.rest.webservice.model.User;

public interface UserService {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);

}
