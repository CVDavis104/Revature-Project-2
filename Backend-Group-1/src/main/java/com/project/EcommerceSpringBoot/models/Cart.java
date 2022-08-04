package com.project.EcommerceSpringBoot.models;

import lombok.Data;

import javax.persistence.*;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart_t")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;

    @OneToMany(mappedBy = "cart_products",fetch = FetchType.LAZY)
    @Column(name = "products")
    private List<Product> products = new ArrayList<>();

    public Cart(){}

    public Cart(int cart_id, List<Product> products) {
        this.cart_id = cart_id;
        this.products = products;
    }
}/*Cart class ending*/
