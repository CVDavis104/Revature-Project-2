package com.project.EcommerceSpringBoot.controllers;

import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.Purchase;
import com.project.EcommerceSpringBoot.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/map")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /*@PostMapping("/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createProduct(@RequestBody Product product){
        return productService.createProduct(product) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }*/

//    @GetMapping("/total_purchase")
//    public @ResponseBody totalPurchase()

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/purchase")
    public @ResponseBody ClientMessage updatePurchaseByUser(@RequestBody Purchase purchase){
        return purchaseService.updatePurchaseByUser(purchase) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @PutMapping("/purchase_quantity")
    public @ResponseBody ClientMessage updatePurchaseQuantityByUser(@RequestBody Purchase purchase){
        return purchaseService.updatePurchaseQuantityByUser(purchase) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

}/*PurchaseController class ending*/