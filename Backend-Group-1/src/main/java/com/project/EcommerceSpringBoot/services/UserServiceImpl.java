package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepo.updateUser(user.getUser_name(), user.getPass_word(), user.getFirst_name(), user.getLast_name(), user.getPhone_number(), user.getEmail(), user.getAddress(), user.getUser_id());
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