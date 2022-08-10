package com.project.EcommerceSpringBoot.controllers;

import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.Purchase;
import com.project.EcommerceSpringBoot.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/map")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
public class PurchaseController {

/* Fields for testing the Purchase in Postman

         {
         "purchase_id": int,
         "user_purchase_rel": int,
         "purchase_product_rel": int,
         "purchase_quantity": int,
         "purchase_price": double
         }

//Example HTTP link for testing
//http://localhost:8080/[RequestMapping]/[MethodMapping]?user_name=[exampleName]&pass_word=[examplePassword]

*///Field testing explanation ending

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/purchase")
    public @ResponseBody ClientMessage updatePurchaseByUser(@RequestBody Purchase purchase){
        return purchaseService.updatePurchaseByUser(purchase) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/purchase")
    public @ResponseBody ClientMessage deletePurchase(@RequestBody Purchase purchase){
        return purchaseService.deletePurchase(purchase) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

    @PatchMapping("/purchase")
    public @ResponseBody ClientMessage updatePurchaseQuantityByUser(@RequestBody Purchase purchase){
        return purchaseService.updatePurchaseQuantityByUser(purchase) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @GetMapping("/purchases")
    public @ResponseBody List<Purchase> getAllPurchases(){
        return purchaseService.getAllPurchases();
    }

}/*PurchaseController class ending*/