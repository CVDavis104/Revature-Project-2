package com.project.EcommerceSpringBoot.models;
import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "usercart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")//...pointing to the user who made this cart
    private User userid;

    @ManyToOne
    @JoinColumn(name = "uc_product_id",  referencedColumnName = "p_id") //...pointing to the products in this cart
    private Product productid;

    @Column(name = "uc_product_qty")
    private int productqty;

    public UserCart() {
    }

    public UserCart(int id) {
        this.id = id;
    }

    public UserCart(User userid, Product productid, int productqty) {
        this.userid = userid;
        this.productid = productid;
        this.productqty = productqty;
    }

    public UserCart(int id, User userid, Product productid, int productqty) {
        this.id = id;
        this.userid = userid;
        this.productid = productid;
        this.productqty = productqty;
    }
}
