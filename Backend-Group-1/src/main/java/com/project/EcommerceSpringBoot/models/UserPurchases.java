package com.project.EcommerceSpringBoot.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userpurchases")
public class UserPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "up_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")//...pointing to the user who made this cart
    private User userid;//...pointing to the user that is making purchases

    @ManyToOne //OneToMany
    @JoinColumn(name = "up_product_id",  referencedColumnName = "p_id") //...pointing to the products in this cart
    private Product productid;


    @Column(name = "up_product_qty")
    private int productqty;
    @Column(name = "up_checkout")
    private boolean checkout;

    public UserPurchases() {
    }

    public UserPurchases(int id) {
        this.id = id;
    }

    public UserPurchases(User userid, Product productid, int productqty, boolean checkout) {
        this.userid = userid;
        this.productid = productid;
        this.productqty = productqty;
        this.checkout = checkout;
    }

    public UserPurchases(int id, User userid, Product productid, int productqty, boolean checkout) {
        this.id = id;
        this.userid = userid;
        this.productid = productid;
        this.productqty = productqty;
        this.checkout = checkout;
    }

    public UserPurchases(User userid) {
        this.userid = userid;
    }
}
