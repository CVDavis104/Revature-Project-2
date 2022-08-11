package com.project.EcommerceSpringBoot.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "e_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_username", unique = true, nullable = false)
    private String username;

    @Column(name = "u_password",  nullable = false)
    private String password;

    @Column(name = "u_firstname", nullable = false)
    private String firstname;

    @Column(name = "u_lastname", nullable = false)
    private String lastname;

    @Column(name = "u_email", nullable = false)
    private String email;

    @Column(name = "u_address")
    private String address;

    @Column(name = "u_phonenumber")
    private String phonenumber;

//    @Column(name = "u_balance")
//    private double balance;

//    @OneToOne
//    @JoinColumn(name = "usercart_id", referencedColumnName = "uc_id")//...pointing to the cart the user makes
//    private UserCart usercartid;


    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String password, String firstname, String lastname, String email, String address, String phonenumber) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public User(int id, String username, String password, String firstname, String lastname, String email, String address, String phonenumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
//        this.balance = balance;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}