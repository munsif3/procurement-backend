package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.PurchaseOrder;
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

    /**
     * This method is used to get all the available purchase orders without
     * considering any filtering attributes.
     * @return - Returns list of purchase order objects.
     */
    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseRepository.findAll();
    }

    /**
     * This method is used to add new purchase orders
     * @param purchaseOrder - Purchase order object is passed as the parameter in order to save the
     *                        purchase order details.
     */
    @Override
    public void addPurchaseOrder(PurchaseOrder purchaseOrder)
    {
        this.purchaseRepository.save(purchaseOrder);
    }

    /**
      * This method is used to get purchase order based on purchase no.
      * @param purchaseId - Each purchase order is uniquely identified by purchase no.
      * @return - Returns one single purchase object which has the provided purchase no.
      */
     @Override
    public PurchaseOrder getPurchaseOrderById(String purchaseId) {
        return purchaseRepository.findOne(purchaseId);
    }

//
//
//    /**
//     * This method is used to delete the purchase order details(purchase order object)
//     * @param purchaseNo - Each purchase order is uniquely identified by purchase no.
//     */
//    @Override
//    public void deletePurchaseOrder(int purchaseNo) {
//        this.purchaseRepository.delete(String.valueOf(purchaseNo));
//    }
//
//    /**
//     * This method is used to list down all the available quotations for a particular requisition order.
//     * @param requisitionId - Each purchase order has a requisition id.
//     * @return
//     */
//    @Override
//    public List<PurchaseOrder> getPurchaseOrderByRequisitionId(int requisitionId) {
//        return null;
//    }
//
//    /**
//     * This method is used to identify a particular purchase order for a particular requisition order.
//     * @param requisitionId - Each purchase order has a requisition id.
//     * @param purchaseNo - Each purchase order is uniquely identified by purchase no.
//     * @return - Returns one single purchase object which has the provided purchase no and the requisition no.
//     */
//    @Override
//    public PurchaseOrder getPurchaseOrderByPurchaseIdAndRequisitionId(int requisitionId,int purchaseNo) {
//        return purchaseRepository.findByRequisitionIdAndPurchaseId(requisitionId,purchaseNo);
//    }
//
//    /**
//     * This method will identify the quotation with minimum amount for a particular requisition order.
//     * This selected quotation will be considered as the optimized purchased order.
//     * @param requisitionId - Each purchase order has a requisition id.
//     * @return - Returns one single purchase object which has the provided requisition no with minimum amount.
//     */
//    @Override
//    public PurchaseOrder getMinimumAmountPurchaseOrder(int requisitionId) {
//        return purchaseRepository.findFirstByRequisitionIdOrderByAmount(requisitionId);
//    }
//
//
//


}
