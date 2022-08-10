package com.project.EcommerceSpringBoot.services;

<<<<<<< HEAD
=======



>>>>>>> CVDavis104
import com.project.EcommerceSpringBoot.models.User;
import java.util.List;

public interface UserService {

<<<<<<< HEAD
    //Creates a new user
    boolean createUser(User user);

    //Get User by id
    User getUserById(int user_id);

    User getUserByUser(String email, String password);

    //Updates a User
    boolean updateUser(User user);
    User getUserByUser(String email, String password);

    

    //Deletes a User
    boolean deleteUser(User user);

    //Get all Users
    List<User> getAllUsers();

    // Logging in
    User getByEmail(String email, String pass_word);


}/*UserService interface ending*/

=======
    boolean createUser(User user);

    User getUserById(int id);

    User getUserByUser(String username, String password);

    List<User> getAllUsers();

    int updateUser(User user);

    boolean deleteUser(User user);
}
///
>>>>>>> CVDavis104
