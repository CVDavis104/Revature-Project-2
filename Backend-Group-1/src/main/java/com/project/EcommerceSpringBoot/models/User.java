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

//    @OneToOne
//    @JoinColumn(name = "usercart_id", referencedColumnName = "uc_id")//...pointing to the cart the user makes
//    private UserCart usercartid;


<<<<<<< HEAD
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
=======
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
//        this.usercartid = usercartid;
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
  //      this.usercartid = usercartid;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
