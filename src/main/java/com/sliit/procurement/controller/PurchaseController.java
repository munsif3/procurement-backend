package com.sliit.procurement.controller;

import com.sliit.procurement.model.Purchase;
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
    public List<Purchase> getAllPurchases()
    {
        return purchaseService.getAllPurchase();
    }

    @ResponseBody
    @RequestMapping(value="/purchases/{id}", method = RequestMethod.GET)
    public Purchase getPurchaseById(@PathVariable String id)
    {
        return purchaseService.getPurchaseById(id);
    }


}
