package com.project.EcommerceSpringBoot.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_t")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;//Points to the product id

    @Column(name = "product_name", unique = true, nullable = false)
    private String product_name;//Points to the product name

    @Column(name = "product_price", nullable = false)
    private double product_price;//Points to the product price

    @Column(name = "product_inventory", nullable = false)
    private int product_inventory;//Points to the product inventory

    //No args constructor
    public Product(){super();}

    //product_inventory constructor
    public Product(int product_inventory) {
        this.product_inventory = product_inventory;
    }//product_inventory constructor ending

    //Product most args constructor
    public Product(String product_name, double product_price, int product_inventory, Cart cart_products) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_inventory = product_inventory;
    }//Product most args constructor ending

    //All args constructor
    public Product(int product_id, String product_name, double product_price, int product_inventory, Cart cart_products) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_inventory = product_inventory;
    }//All args constructor ending

}/*Products class ending*/

