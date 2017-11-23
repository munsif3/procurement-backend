package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.repository.PurchaseOrderRepository;
import com.sliit.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder addPurchaseOrder(PurchaseOrder addPurchaseOrder) {
        return purchaseOrderRepository.save(addPurchaseOrder);
    }

    @Override
    public  PurchaseOrder  updatePurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderByStatus(String status) {
        return purchaseOrderRepository.findByStatus(status);
    }

    @Override
    public List<PurchaseOrder> getOrderByStatus() {
        return purchaseOrderRepository.getOrderByStatus();
    }

    @Override
    public PurchaseOrder getPurchaseOrderByPurchaseNo(int purchaseNo) {
        return purchaseOrderRepository.findByPurchaseNo(purchaseNo);
    }

    @Override
    public PurchaseOrder getPurchaseOrderByPurchaseId(String purchaseId) {
        return purchaseOrderRepository.findByPurchaseId(purchaseId);
    }

//    @Override
//    public PurchaseOrder getPurchaseOrderByPurchaseId(String purchaseId) {
//        return purchaseOrderRepository.findOne(purchaseId);
//    }


}
