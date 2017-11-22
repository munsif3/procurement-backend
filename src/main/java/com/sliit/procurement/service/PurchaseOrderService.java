package com.sliit.procurement.service;

import com.sliit.procurement.model.PurchaseOrder;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderService {

    List<PurchaseOrder> getAllPurchaseOrders();

    PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder);
}
