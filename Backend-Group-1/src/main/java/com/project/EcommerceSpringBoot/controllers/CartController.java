package com.project.EcommerceSpringBoot.controllers;
import com.project.EcommerceSpringBoot.models.Cart;
import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/map")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
public class CartController {

    
/* Fields for testing the Cart in Postman

         {
         "cart_id": int,
         "cart_user_rel": int,
         "cart_product_id": int,
         "product_quantity": int
         }
//Example HTTP link for testing
//http://localhost:8080/[RequestMapping]/[MethodMapping]?user_name=[exampleName]&pass_word=[examplePassword]

*///Field testing explanation ending

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createCart(@RequestBody Cart cart){
        return cartService.createCart(cart) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }//createCart method ending
    //{
//        "userid":1,
//        "productid":1,
//        "productqty":10
//}

    @PutMapping("/cart")
    public @ResponseBody ClientMessage updateCart(@RequestBody Cart cart){
        return cartService.updateCart(cart) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
//                "id":4,
//                "userid":2,
//                "productid":5,
//                "productqty":18
    }//updateCart method ending

    @PutMapping("/cartById")//formerly updateCartByUserId method
    public @ResponseBody ClientMessage updateCartProductsQuantity(@RequestBody Cart cart){
        return cartService.updateCartProductsQuantity(cart) > 0 ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
//                "id":4,
//                "productqty":18
    }//updateCartProductsQuantity method ending

    @GetMapping("/cart")
    public @ResponseBody Cart findCartById(@RequestParam int cart_id) {
        return cartService.findCartById(cart_id);
    }//findCartById method ending

    @GetMapping("/cartByUser")
    public @ResponseBody List<Cart> findCartByUser(@RequestParam User cart_user_rel) {
        return cartService.findCartByUser(cart_user_rel);
    }//findCartByUser method ending
    //http://localhost:8080/api/usercartUser?userid=1

    @DeleteMapping("/cart")
    public @ResponseBody ClientMessage deleteCart(@RequestBody Cart cart){
        return cartService.deleteCart(cart) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }//deleteCart method ending

    @GetMapping("/carts")
    public @ResponseBody List<Cart> getAll(){
        return cartService.findAllUserCarts();
    }//getAll method ending

//                "userid":1,       //this field will be added to the purchase table
//                "productid":1,    //this field will be added to the purchase table
//                "productqty":10,  //this field will be added to the purchase table
//                "id":1  //need to add the the user cart id so record can be deleted

}/*CartController class ending*/


