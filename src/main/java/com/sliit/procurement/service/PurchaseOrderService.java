package com.sliit.procurement.service;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.model.PurchaseOrderItemPK;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderService {

    List<PurchaseOrder> getAllPurchaseOrders();

    PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> getRequisitionOrderByStatus();

    List<PurchaseOrder> getPurchaseOrderByStatus(String status);

    PurchaseOrder getPurchaseOrderByPurchaseNo(int purchaseNo);

    PurchaseOrder getPurchaseOrderByPurchaseId(String purchaseId);


//    List<PurchaseOrder>
    //PurchaseOrder getPurchaseOrderByPurchaseId(String purchaseId);

}
