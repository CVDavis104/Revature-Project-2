package com.project.EcommerceSpringBoot.services;

<<<<<<< HEAD
=======



>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
import com.project.EcommerceSpringBoot.models.User;

import java.util.List;

public interface UserService {

<<<<<<< HEAD
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
=======
    boolean createUser(User user);

    User getUserById(int id);

    User getUserByUser(String username, String password);

    List<User> getAllUsers();

    int updateUser(User user);

    boolean deleteUser(User user);
}
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
