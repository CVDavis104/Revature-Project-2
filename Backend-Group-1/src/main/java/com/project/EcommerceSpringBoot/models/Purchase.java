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

}/*Purchase class ending*/