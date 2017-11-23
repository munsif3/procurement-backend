package com.sliit.procurement.controller;

import com.sliit.procurement.model.PurchaseOrderItem;
import com.sliit.procurement.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */

@RestController
@CrossOrigin
public class PurchaseOrderItemController {

    @Autowired
    PurchaseOrderItemService purchaseOrderItemService;

    @ResponseBody
    @RequestMapping(value = "/purchaseOrderItems", method = RequestMethod.POST, consumes = "application/json")
    public PurchaseOrderItem addPurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemService.addPurchaseOrderItem(purchaseOrderItem);
    }


    @ResponseBody
    @RequestMapping(value = "/purchaseOrderItems", method = RequestMethod.GET)
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemService.getAllPurchaseOrderItems();
    }
}
