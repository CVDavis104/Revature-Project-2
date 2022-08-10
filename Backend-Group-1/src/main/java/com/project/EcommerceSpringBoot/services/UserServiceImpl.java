package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){this.userRepo = userRepo;}

    @Override
    public boolean createUser(User user) {
        int pk = userRepo.save(user).getUser_id();
            return (pk > 0) ? true: false;
    }//Create User method ending

    @Override
    public User getUserById(int user_id) {
        try{
            Optional<User> userTarget = userRepo.findById(user_id);
            User user = userTarget.get();
            return user;
        }//try block ending

        catch(NoSuchElementException e){
            System.out.println(e.getLocalizedMessage());
        }//catch block ending

        return null;
    }//getUserById method ending

    @Override
    public boolean updateUser(User user) {
        int pk = userRepo.updateUser(user.getUser_name(), user.getPass_word(), user.getFirst_name(), user.getLast_name(), user.getPhone_number(), user.getEmail(), user.getAddress(), user.getUser_id());
            return (pk > 0) ? true: false;
    }//updateUser method ending

    public User getUserByUser(String email, String password) {
        return uRepo.findByUser(email, password);
=======
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo uRepo;

    @Autowired
    public UserServiceImpl(UserRepo uRepo) {
        this.uRepo = uRepo;
    }

    @Override
    public boolean createUser(User user) {
        int pk = uRepo.save(user).getId();
        return (pk > 0) ? true : false ;
    }

    @Override
    public User getUserById(int id) {
        return uRepo.findById(id);
    }

    @Override
    public User getUserByUser(String username, String password) {
        return uRepo.findByUser(username, password);
>>>>>>> CVDavis104
    }

    @Override
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }

    @Override
    public int updateUser(User user) {
        return uRepo.update(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhonenumber(), user.getId());
    }


<<<<<<< HEAD

}/*UserServiceImpl class ending*/
=======
    @Override
    public boolean deleteUser(User user) {
        uRepo.delete(user);
        return true;
    }
}
////
>>>>>>> CVDavis104
