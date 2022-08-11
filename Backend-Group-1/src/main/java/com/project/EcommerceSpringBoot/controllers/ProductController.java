package com.project.EcommerceSpringBoot.controllers;
import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public @ResponseBody Product getById(@RequestParam int id) {
        return productService.getProductById(id);
    }
    

    @GetMapping("/products")
    public @ResponseBody List<Product> getAll(){
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createProduct(@RequestBody Product product){
        return productService.createProduct(product) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/product")
    public @ResponseBody ClientMessage updateProduct(@RequestBody Product product){
        return productService.updateProduct(product) > 0 ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/product")
    public @ResponseBody ClientMessage deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}

// {

//         {
//         "id": 2,
//         "name": "Venom",
//         "price": 50.0,
//         "invcount": 80
//         },
//         {
//         "id": 3,
//         "name": "Goku",
//         "price": 60.0,
//         "invcount": 70
//         },
//         {
//         "id": 4,
//         "name": "Batman",
//         "price": 80.0,
//         "invcount": 70
//         },
//         {
//         "id": 5,
//         "name": "Charizard",
//         "price": 200.0,
//         "invcount": 120
//         }