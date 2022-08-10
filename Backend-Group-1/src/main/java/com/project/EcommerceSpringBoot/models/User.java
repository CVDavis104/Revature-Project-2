package com.project.EcommerceSpringBoot.models;
import lombok.Data;

import javax.persistence.*;

//Checkout
//Creating user purchase
//set up services
//updating user purchases
@Entity
@Data
@Table(name = "user_t")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;//Points to the user id

    @Column(name = "user_name")
    private String user_name;//Points to the username

    @Column(name = "pass_word", nullable = true)
    private String pass_word;//Points to the password

    @Column(name = "first_name")
    private String first_name;//Points to a users first name

    @Column(name = "last_name")
    private String last_name;//Points to a users last name

    @Column(name = "email", unique = true, nullable = false)
    private String email;//Points to a users email

    @Column(name = "address")
    private String address;//Points to a users address

    @Column(name = "phone_number")
    private String phone_number;//Points to a users phone number

    @OneToOne(cascade = CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "user_cart_rel", referencedColumnName = "cart_id")//...pointing to the cart the user makes
    private Cart user_cart_rel;//Points to the user accounts cart id

    //No args constructor
    public User() {super();}

    //User id constructor
    public User(int user_id) {
        this.user_id = user_id;
    }//User id constructor ending

    //User login constructor
    public User(String email, String pass_word) {
        this.email = email;
        this.pass_word = pass_word;
    }//User login constructor ending



    //User signup constructor
    public User(String user_name, String pass_word, String first_name, String last_name, String email, String address, String phone_number) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
    }//User signup constructor ending

    


    //All args constructor
    public User(int user_id, String user_name, String pass_word, String first_name, String last_name, String email, String address, String phone_number, Cart user_cart_rel) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.user_cart_rel = user_cart_rel;
    }//All args constructor ending

   

   
}/*User class ending*/


