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
        return purchaseService.getAllPurchase();
    }

    @ResponseBody
    @RequestMapping(value="/purchases/{id}", method = RequestMethod.GET)
    public PurchaseOrder getPurchaseById(@PathVariable String id)
    {
        return purchaseService.getPurchaseById(id);
    }

    @RequestMapping(value = "/purchases/req/{id}", method = RequestMethod.GET)
    public List<PurchaseOrder> getPurchaseOrderByRequisitionId(@PathVariable String id) {
        return purchaseService.getPurchaseOrderByRequisitionId(id);
    }

}
