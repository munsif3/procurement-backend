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

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders()
    {
        return purchaseRepository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(int purchaseNo) {
        return purchaseRepository.findOne(String.valueOf(purchaseNo));
    }

    @Override
    public void deletePurchaseOrder(int purchaseNo) {
        this.purchaseRepository.delete(String.valueOf(purchaseNo));
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderByRequisitionId(int requisitionId) {
        return null;
    }

    @Override
    public PurchaseOrder getPurchaseOrderByPurchaseIdAndRequisitionId(int requisitionId,int purchaseNo) {
        return purchaseRepository.findByRequisitionIdAndPurchaseId(requisitionId,purchaseNo);
    }

    @Override
    public PurchaseOrder getMinimumAmountPurchaseOrder(int requisitionId) {
        return purchaseRepository.findFirstByRequisitionIdOrderByAmount(requisitionId);
    }

    @Override
    public void addPurchaseOrder(PurchaseOrder purchaseOrder)
    {
        this.purchaseRepository.save(purchaseOrder);
    }

}
