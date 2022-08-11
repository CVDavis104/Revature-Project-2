package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    public CartServiceImpl(CartRepo cartRepo){this.cartRepo = cartRepo;}

    @Override
    public boolean createCart(Cart cart) {
        int pk = cartRepo.save(cart).getCart_id();
        return (pk > 0) ? true : false;
    }//Create Cart method ending

    @Override
    public boolean updateCart(Cart cart) {
        return cartRepo.updateCart(cart.getCart_user_rel(),cart.getCart_product_id(),cart.getProduct_quantity(),cart.getCart_id());
    }//Update Cart method ending

    @Override
    public int updateCartProductsQuantity(Cart cart) {
        return cartRepo.updateCartProductsQuantity(cart.getProduct_quantity(), cart.getCart_id());
    }//Update Product quantity in a cart

    @Override
    public Cart findCartById(int cart_id) {
        return cartRepo.findCartById(cart_id);
    }//Find Cart by cart id method ending

    @Override
    public List<Cart> findCartByUser(User cart_user_rel) {
        return cartRepo.findCartByUser(cart_user_rel);
    }//Find Cart by user id method ending

//    @Override
//    public int createPurchase(Product product) {
//        return cartRepo.insertPurchase(,product);
//    }//Inserts Products being purchased into the purchase table

//public int insertPurchase(User user_purchase_rel, Product purchase_product_rel, int product_quantity);
    @Override
    public boolean deleteCart(Cart cart) {
        cartRepo.delete(cart);
        return true;
    }//Delete a Cart method ending

    @Override
    public List<Cart> findAllUserCarts() {
        return cartRepo.findAll();
    }//Finds all Carts method ending

//
//
//    @Override
//    public int updateUserCartById(UserCart userCart) {
//        return ucRepo.updateById(userCart.getProductqty(),userCart.getId());
//    }
//
//    @Override
//    public int createPurchase(UserCart userCart) {
//        ucRepo.delete(userCart);
//        return ucRepo.insertPurchase(userCart.getUserid(), userCart.getProductid(),userCart.getProductqty());
//
//    }

    /*    //Inserts Products being purchased into the purchase table
    int insertPurchase(Product product);*/
}
