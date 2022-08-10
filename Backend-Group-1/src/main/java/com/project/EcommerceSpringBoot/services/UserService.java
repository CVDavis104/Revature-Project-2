package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import java.util.List;

public interface UserService {

    //Creates a new user
    boolean createUser(User user);

    //Get User by id
    User getUserById(int user_id);

<<<<<<< HEAD
<<<<<<< HEAD
    //Updates a User
    boolean updateUser(User user);
=======
    User getUserByUser(String email, String password);
>>>>>>> markclone
=======
    User getUserByUser(String email, String password);
>>>>>>> markclone

    //Deletes a User
    boolean deleteUser(User user);

    //Get all Users
    List<User> getAllUsers();

    // Logging in
    User getByEmail(String email, String pass_word);


}/*UserService interface ending*/

