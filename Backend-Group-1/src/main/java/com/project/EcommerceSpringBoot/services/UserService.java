package com.project.EcommerceSpringBoot.services;




import com.project.EcommerceSpringBoot.models.User;

import java.util.List;

public interface UserService {

    boolean createUser(User user);

    User getUserById(int id);

    User getByEmail(String email, String password);

    List<User> getAllUsers();

    int updateUser(User user);

    boolean deleteUser(User user);
}
///