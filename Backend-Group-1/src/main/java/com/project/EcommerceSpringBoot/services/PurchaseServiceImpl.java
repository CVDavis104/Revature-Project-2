package com.project.EcommerceSpringBoot.services;
import com.project.EcommerceSpringBoot.models.Purchase;
import com.project.EcommerceSpringBoot.repos.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo){this.purchaseRepo = purchaseRepo;}

    @Override
    public boolean createPurchase(Purchase purchase) {
        int pk = purchaseRepo.save(purchase).getPurchase_id();
        return (pk > 0) ? true : false;
    }//createPurchase method ending

    @Override
    public boolean updatePurchaseByUser(Purchase purchase) {
        return purchaseRepo.updatePurchaseByUser(purchase.getPurchase_quantity(), purchase.getPurchase_price(),purchase.getPurchase_product_rel(),purchase.getUser_purchase_rel(), purchase.getPurchase_id());
    }//updatePurchaseByUser method ending

    @Override
    public boolean updatePurchaseQuantityByUser(Purchase purchase) {
        return purchaseRepo.updatePurchaseQuantityByUser(purchase.getPurchase_quantity(),purchase.getUser_purchase_rel());
    }//updatePurchaseQuantityByUser method ending

    @Override
    public boolean deletePurchase(Purchase purchase) {
        purchaseRepo.delete(purchase);
        return true;
    }//deletePurchase method ending

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }//getAllPurchases method ending

}/*PurchaseServiceImpl class ending*/
