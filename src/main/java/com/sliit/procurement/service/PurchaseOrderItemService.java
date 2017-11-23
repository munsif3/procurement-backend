package com.sliit.procurement.service;

import com.sliit.procurement.model.PurchaseOrderItem;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderItemService {

    PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);

    List<PurchaseOrderItem> getAllPurchaseOrderItems();
}
