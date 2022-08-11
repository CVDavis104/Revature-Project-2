package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.repos.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserPurchasesServiceImpl implements UserPurchasesService{

    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    public UserPurchasesServiceImpl(PurchaseRepo purchaseRepo){this.purchaseRepo = purchaseRepo;}

    @Override
    public boolean getByCheckout(boolean checkout, int id) {
        return purchaseRepo.updateByCheckout(checkout, id);
    }
}
