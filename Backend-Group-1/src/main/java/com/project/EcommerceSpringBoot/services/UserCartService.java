package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.models.UserCart;
import com.project.EcommerceSpringBoot.models.UserPurchases;

import java.util.List;

public interface UserCartService {

    boolean createUserCart(UserCart userCart);

    UserCart getUserCartById(int id);

    List<UserCart> getUserCartByUser(User userid);

    List<UserCart> getAllUserCarts();

    int updateUserCart(UserCart userCart);

    int updateUserCartById(UserCart userCart);

    int createPurchase(UserCart userCart);

    boolean deleteUserCart(UserCart userCart);
}
