package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;

import java.util.List;

public interface UserService {

    //Creates a new user
    boolean createUser(User user);

    //Get User by id
    User getUserById(int user_id);

    //Updates a User
    boolean updateUser(User user);

    //Deletes a User
    boolean deleteUser(User user);

    //Get all Users
    List<User> getAllUsers();

}/*UserService interface ending*/
