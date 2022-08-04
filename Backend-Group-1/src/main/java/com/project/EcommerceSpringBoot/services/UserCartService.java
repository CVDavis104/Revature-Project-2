package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.UserCart;

import java.util.List;

public interface UserCartService {

    boolean createUserCart(UserCart userCart);

    UserCart getUserCartById(int id);

    List<UserCart> getAllUserCarts();

    int updateUserCart(UserCart userCart);

    boolean deleteUserCart(UserCart userCart);
}
