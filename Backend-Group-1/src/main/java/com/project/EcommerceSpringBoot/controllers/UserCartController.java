package com.project.EcommerceSpringBoot.controllers;
import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.UserCart;
import com.project.EcommerceSpringBoot.services.ProductService;
import com.project.EcommerceSpringBoot.services.UserCartService;
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

    @GetMapping("/usercart")
    public @ResponseBody UserCart getById(@RequestParam int id) {
        return userCartService.getUserCartById(id);
    }

    @GetMapping("/usercarts")
    public @ResponseBody List<UserCart> getAll(){
        return userCartService.getAllUserCarts();
    }

    @PostMapping("/usercart")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createUserCart(@RequestBody UserCart userCart){
        return userCartService.createUserCart(userCart) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/usercart")
    public @ResponseBody ClientMessage updateUserCart(@RequestBody UserCart userCart){
        return userCartService.updateUserCart(userCart) > 0 ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/usercart")
    public @ResponseBody ClientMessage deleteUserCart(@RequestBody UserCart userCart){
        return userCartService.deleteUserCart(userCart) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}


//{
//        "userid":1,
//        "productid":1,
//        "productqty":10
//}