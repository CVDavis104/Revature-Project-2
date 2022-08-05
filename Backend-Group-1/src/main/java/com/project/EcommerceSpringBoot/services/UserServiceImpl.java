package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
