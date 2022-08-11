package com.project.EcommerceSpringBoot.controllers;
import com.project.EcommerceSpringBoot.models.*;
import com.project.EcommerceSpringBoot.services.ProductService;
import com.project.EcommerceSpringBoot.services.UserCartService;
import com.project.EcommerceSpringBoot.services.UserPurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})

public class UserCartController {
    @Autowired
    private UserCartService userCartService;

    @Autowired
    private UserPurchasesService userPurchasesService;

    @GetMapping("/usercart")
    public @ResponseBody UserCart getById(@RequestParam int id) {
        return userCartService.getUserCartById(id);
    }

    @GetMapping("/usercartUser")
    public @ResponseBody List<UserCart> getByUser(@RequestParam User userid) {
        return userCartService.getUserCartByUser(userid);
        //http://localhost:8080/api/usercartUser?userid=1
    }
    @GetMapping("/usercarts")
    public @ResponseBody List<UserCart> getAll(){
        return userCartService.getAllUserCarts();
    }

    @PostMapping("/usercart")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createUserCart(@RequestBody UserCart userCart){
        return userCartService.createUserCart(userCart) ? CREATION_SUCCESSFUL : CREATION_FAILED;
//{
//        "userid":1,
//        "productid":1,
//        "productqty":10
//}
    }

    @PostMapping("/usercartPurchase")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createPurchase(@RequestBody UserCart userCart) {
        return userCartService.createPurchase(userCart) > 0 ? CREATION_SUCCESSFUL : CREATION_FAILED;
//        {
//                "userid":1,       //this field will be added to the purchase table
//                "productid":1,    //this field will be added to the purchase table
//                "productqty":10,  //this field will be added to the purchase table
//                "id":1  //need to add the the user cart id so record can be deleted
//        }
    }
    @PutMapping("/usercartById")
    public @ResponseBody ClientMessage updateUserCartById(@RequestBody UserCart userCart){
        return userCartService.updateUserCartById(userCart) > 0 ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
//                "id":4,
//                "productqty":18
    }

    @PutMapping("/checkout")
    public @ResponseBody ClientMessage updateByCheckout(@RequestBody boolean checkout, int id) {
        return userPurchasesService.getByCheckout(checkout, id) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
//                "id":4,
//                "productqty":18
    }

    @PutMapping("/usercart")
    public @ResponseBody ClientMessage updateUserCart(@RequestBody UserCart userCart){
        return userCartService.updateUserCart(userCart) > 0 ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
//                "id":4,
//                "userid":2,
//                "productid":5,
//                "productqty":18
    }

    @DeleteMapping("/usercart")
    public @ResponseBody ClientMessage deleteUserCart(@RequestBody UserCart userCart){
        return userCartService.deleteUserCart(userCart) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}
///