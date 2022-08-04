package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.UserCart;
import com.project.EcommerceSpringBoot.repos.UserCartRepo;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    private UserCartRepo ucRepo;

    @Autowired
    public UserCartServiceImpl(UserCartRepo ucRepo) {
        this.ucRepo = ucRepo;
    }
    @Override
    public boolean createUserCart(UserCart userCart) {
        int pk = ucRepo.save(userCart).getId();
        return (pk > 0) ? true : false ;
    }

    @Override
    public UserCart getUserCartById(int id) {
        return ucRepo.findById(id);
    }

    @Override
    public List<UserCart> getAllUserCarts() {
        return ucRepo.findAll();
    }

    @Override
    public int updateUserCart(UserCart userCart) {
        return ucRepo.update(userCart.getProductqty(), userCart.getProductid(), userCart.getId());
    }

    @Override
    public boolean deleteUserCart(UserCart userCart) {
        ucRepo.delete(userCart);
        return true;
    }
}
