package com.project.EcommerceSpringBoot.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart_t")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;//Points to the cart id

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_user_rel", referencedColumnName = "user_id")
    private User cart_user_rel;//Points to the user who made this cart

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_product_id",  referencedColumnName = "product_id")
    private Product cart_product_id;//Points to the products in this cart

    @Column(name = "product_quantity")
    private int product_quantity;//Points to the product quantity inside a cart

    //No arg constructor
    public Cart() {super();}

    //Cart id constructor
    public Cart(int cart_id) {
        this.cart_id = cart_id;
    }//Cart id constructor ending

    //cart_user_rel constructor
    public Cart(User cart_user_rel) {
        this.cart_user_rel = cart_user_rel;
    }//Cart_user_rel constructor ending

    //Cart most args constructor
    public Cart(User cart_user_rel, Product cart_product_id, int product_quantity) {
        this.cart_user_rel = cart_user_rel;
        this.cart_product_id = cart_product_id;
        this.product_quantity = product_quantity;
    }//Cart most args constructor ending

    //Cart all args constructor
    public Cart(int cart_id, User cart_user_rel, Product cart_product_id, int product_quantity) {
        this.cart_id = cart_id;
        this.cart_user_rel = cart_user_rel;
        this.cart_product_id = cart_product_id;
        this.product_quantity = product_quantity;
    }//Cart all args constructor ending

}/*Cart class ending*/
