package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.Purchase;

import java.util.List;

public interface PurchaseService {

    boolean createPurchase(Purchase purchase);

    boolean updatePurchaseByUser(Purchase purchase);

    boolean updatePurchaseQuantityByUser(Purchase purchase);

    boolean deletePurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

}/*PurchaseService interface ending*/
