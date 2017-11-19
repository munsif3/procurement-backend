package com.sliit.procurement.controller;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */

@RestController
@CrossOrigin
public class PurchaseController
{
    @Autowired
    PurchaseService purchaseService;

    @ResponseBody
    @RequestMapping(value="/purchases", method = RequestMethod.GET)
    public List<PurchaseOrder> getAllPurchases()
    {
        return purchaseService.getAllPurchaseOrders();
    }

    @ResponseBody
    @RequestMapping(value="/purchases/{id}", method = RequestMethod.GET)
    public PurchaseOrder getPurchaseById(@PathVariable int id)
    {
        return purchaseService.getPurchaseOrderById(id);
    }

    @RequestMapping(value = "/purchases/req/{id}", method = RequestMethod.GET)
    public List<PurchaseOrder> getPurchaseOrderByRequisitionId(@PathVariable int id) {
        return purchaseService.getPurchaseOrderByRequisitionId(id);
    }

    @RequestMapping(value = "/purchases/{requisitionId}/{purchaseId}", method = RequestMethod.GET)
    public PurchaseOrder getPurchaseOrderByPurchaseIdAndRequisitionId(@PathVariable int requisitionId, @PathVariable int purchaseNo)
    {
        return purchaseService.getPurchaseOrderByPurchaseIdAndRequisitionId(requisitionId, purchaseNo);
    }

    @RequestMapping(value = "/purchases/min/{requisitionId}", method = RequestMethod.GET)
    public PurchaseOrder getMinimumAmountPurchaseOrder(@PathVariable int requisitionId) {
        return purchaseService.getMinimumAmountPurchaseOrder(requisitionId);
    }

    @RequestMapping(value="/purchases",method = RequestMethod.POST)
    public void savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
         purchaseService.addPurchaseOrder(purchaseOrder);
    }

}
