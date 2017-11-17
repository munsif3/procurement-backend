package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.Purchase;
import com.sliit.procurement.repository.PurchaseRepository;
import com.sliit.procurement.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */

@Service
public class PurchaseServiceImpl implements PurchaseService
{
    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getPurchaseById(String id) {
        return purchaseRepository.findOne(id);
    }

    @Override
    public void deletePurchase(String id) {
        purchaseRepository.delete(id);
    }
}
