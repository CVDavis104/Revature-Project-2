package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import javax.transaction.Transactional;
import java.util.List;
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
        Optional<User> userSearch = userRepo.findById(user_id);
        User user = userSearch.get();
        return user;
    }//getUserById method ending

    @Override
    public boolean updateUser(User user) {
        return userRepo.updateUser(user.getUser_name(), user.getPass_word(), user.getFirst_name(), user.getLast_name(), user.getPhone_number(), user.getEmail(), user.getAddress(), user.getCart(), user.getUser_id());
    }//updateUser method ending

    @Override
    public boolean deleteUser(User user) {
        userRepo.delete(user);
        return true;
    }//deleteUser method ending

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }//getAllUsers method ending

}/*UserServiceImpl class ending*/
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
    }

    @Override
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }

    @Override
    public int updateUser(User user) {
        return uRepo.update(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhonenumber(), user.getId());
    }


    @Override
    public boolean deleteUser(User user) {
        uRepo.delete(user);
        return true;
    }
}
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
