package com.project.EcommerceSpringBoot.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_t")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product-id")
    private int product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_price")
    private double product_price;

    @Column(name = "product_description")
    private String product_description;

    /*NOTE: This may need to be part of
    a OneToOne relationship with our
     purchase_quantity column in Purchase*/
    @Column(name = "product_inventory")
    private int product_inventory;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_products")//This is our foreign key...
    private Cart cart_products;//...pointing to a cart where our products would be

    public Product() {}

    public Product(String product_name, double product_price, String product_description, int product_inventory, Cart cart_products) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_inventory = product_inventory;
        this.cart_products = cart_products;
    }

    public Product(int product_id, String product_name, double product_price, String product_description, int product_inventory, Cart cart_products) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_inventory = product_inventory;
        this.cart_products = cart_products;
    }
}/*Products class ending*/