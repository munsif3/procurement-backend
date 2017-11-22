package com.sliit.procurement.controller;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
@RestController
@CrossOrigin
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.GET)
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.POST, consumes = "application/json")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.addPurchaseOrder(purchaseOrder);
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.PUT)
    public PurchaseOrder updatePurchaseOrder(@RequestBody final PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
    }

//    @ResponseBody
//    @RequestMapping(value = "/purchaseOrders/{purchaseId}", method = RequestMethod.GET)
//    public PurchaseOrder getPurchaseOrderByPurchaseId(@PathVariable String purchaseId)
//    {
//        return purchaseOrderService.getPurchaseOrderByPurchaseId(purchaseId);
//    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders/requisitions", method = RequestMethod.GET)
    public List<PurchaseOrder> getRequisitionOrderByStatus()
    {
        return purchaseOrderService.getRequisitionOrderByStatus();
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders/purchaseHistory", method = RequestMethod.GET)
    public List<PurchaseOrder> getPurchaseOrderByStatus()
    {
        return purchaseOrderService.getPurchaseOrderByStatus();
    }
}
