package com.sliit.procurement.service;

import com.sliit.procurement.model.Purchase;

import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */
public interface PurchaseService
{
    List<Purchase> getAllPurchase();

    Purchase getPurchaseById(String id);

    void deletePurchase(String id);

}
