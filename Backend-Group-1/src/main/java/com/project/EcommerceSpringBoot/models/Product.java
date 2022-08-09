package com.project.EcommerceSpringBoot.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int id;

    @Column(name = "p_name", unique = true, nullable = false)
    private String name;

    @Column(name = "p_price", nullable = false)
    private double price;

    @Column(name = "p_invcount", nullable = false)
    private int invcount;

//    @ManyToOne
//    @JoinColumn(name = "usercart_id", referencedColumnName = "uc_id") //This is our foreign key...
//    private UserCart usercartid; //...pointing to the usercart that has these products

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

<<<<<<< HEAD
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
=======
    public Product(String name, double price, int invcount) {
        this.name = name;
        this.price = price;
        this.invcount = invcount;
    }

    public Product(int id, String name, double price, int invcount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.invcount = invcount;
    }

}
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
