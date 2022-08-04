package com.project.EcommerceSpringBoot.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_t")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name",unique = true,nullable = false)
    private String user_name;

    @Column(name = "pass_word",nullable = false)
    private String pass_word;

    @Column(name = "first_name",nullable = false)
    private String first_name;

    @Column(name = "last_name",nullable = false)
    private String last_name;

    @Column(name = "phone_number",nullable = false)
    private int phone_number;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "address",nullable = false)
    private String address;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_cart",referencedColumnName = "cart_id")
    private Cart cart;

    @OneToMany(mappedBy = "purchases",fetch = FetchType.LAZY)
    @Column(name = "user_purchases")
    private List<Purchase> purchases = new ArrayList<>();

    /*No args constructor*/
    public User() {super();}

    public User(String user_name, String pass_word, String first_name, String last_name, int phone_number, String email, String address) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public User(String user_name, String pass_word, String first_name, String last_name, int phone_number, String email, String address, Cart cart, List<Purchase> purchases) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.cart = cart;
        this.purchases = purchases;
    }

    public User(int user_id, String user_name, String pass_word, String first_name, String last_name, int phone_number, String email, String address, Cart cart, List<Purchase> purchases) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.cart = cart;
        this.purchases = purchases;
    }
}/*User class ending*/