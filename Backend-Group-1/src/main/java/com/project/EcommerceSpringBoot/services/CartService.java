package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;

import java.util.List;

public interface CartService {

    //Creates a new cart
    boolean createCart(Cart cart);

    //Updates a Cart
    boolean updateCart(Cart cart);

    //Updates the Product Quantity in a Cart
    int updateCartProductsQuantity(Cart cart);

    //Get Cart by cart id
    Cart findCartById(int cart_id);

    //Get Cart by user_id
    List<Cart> findCartByUser(User cart_user_rel);

    //Inserts Products being purchased into the purchase table
//    int insertPurchase(Product product);

    //Deletes a Cart
    boolean deleteCart(Cart cart);

    List<Cart> findAllUserCarts();

/*
    int createPurchase(UserCart userCart);

    boolean deleteUserCart(UserCart userCart);

        //Get all products in a cart
//    List<Product> getAllCartProducts(Product product);

    */

}/*CartService interface ending*/