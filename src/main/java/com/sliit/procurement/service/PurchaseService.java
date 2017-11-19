package com.sliit.procurement.service;

import com.sliit.procurement.model.PurchaseOrder;

import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */
public interface PurchaseService
{
    List<PurchaseOrder> getAllPurchase();

    PurchaseOrder getPurchaseById(String id);

    void deletePurchase(String id);

    List<PurchaseOrder> getPurchaseOrderByRequisitionId(String requisitionId);

}
