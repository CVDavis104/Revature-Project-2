package com.project.EcommerceSpringBoot.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "purchase_t")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchase_id;//Points to the purchase_id

    @ManyToOne
    @JoinColumn(name = "user_purchase_rel", referencedColumnName = "user_id")
    private User user_purchase_rel;//Pointing to the user that is making the purchases

    @ManyToOne
    @JoinColumn(name = "purchase_product_rel",  referencedColumnName = "product_id")
    private Product purchase_product_rel;//Points to the products in this cart

    @Column(name = "purchase_quantity")
    private int purchase_quantity;//Points to the quantity of purchases

    @Column(name = "purchase_price")
    private double purchase_price;//Points to the total purchase price of a users products

    //No args constructor
    public Purchase() {super();}

    //purchase_id constructor
    public Purchase(int purchase_id) {
        this.purchase_id = purchase_id;
    }//purchase_id constructor ending

    //user_purchase_rel constructor
    public Purchase(User user_purchase_rel) {
        this.user_purchase_rel = user_purchase_rel;
    }//user_purchase_rel constructor

    //Purchase most args constructor
    public Purchase(User user_purchase_rel, Product purchase_product_rel, int purchase_quantity, int purchase_price) {
        this.user_purchase_rel = user_purchase_rel;
        this.purchase_product_rel = purchase_product_rel;
        this.purchase_quantity = purchase_quantity;
        this.purchase_price = purchase_price;
    }//Purchase most args constructor ending

    //All args constructor
    public Purchase(int purchase_id, User user_purchase_rel, Product purchase_product_rel, int purchase_quantity, int purchase_price) {
        this.purchase_id = purchase_id;
        this.user_purchase_rel = user_purchase_rel;
        this.purchase_product_rel = purchase_product_rel;
        this.purchase_quantity = purchase_quantity;
        this.purchase_price = purchase_price;
    }//All args constructor

}/*Purchase class ending*/
