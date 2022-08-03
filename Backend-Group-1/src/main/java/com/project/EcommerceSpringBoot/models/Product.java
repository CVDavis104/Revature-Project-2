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

}/*Products class ending*/