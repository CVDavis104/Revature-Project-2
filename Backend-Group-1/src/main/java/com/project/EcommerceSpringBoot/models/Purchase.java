package com.project.EcommerceSpringBoot.models;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchase_t")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    private int purchase_id;

    @Column(name = "purchase_quantity")
    private int purchase_quantity;

    @Column(name = "checkout")
    private boolean checkout;

    @Column(name = "total_amount")
    private double total_amount;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "purchases")//This is our foreign key...
    private Cart purchases;//...pointing to the user that is making purchases

    /*No args constructor*/
    public Purchase() {super();}

    public Purchase(int purchase_quantity, boolean checkout, double total_amount, Cart purchases) {
        this.purchase_quantity = purchase_quantity;
        this.checkout = checkout;
        this.total_amount = total_amount;
        this.purchases = purchases;
    }

    public Purchase(int purchase_id, int purchase_quantity, boolean checkout, double total_amount, Cart purchases) {
        this.purchase_id = purchase_id;
        this.purchase_quantity = purchase_quantity;
        this.checkout = checkout;
        this.total_amount = total_amount;
        this.purchases = purchases;
    }
}/*Purchase class ending*/