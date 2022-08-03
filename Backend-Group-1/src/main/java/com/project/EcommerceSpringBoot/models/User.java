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

}/*User class ending*/