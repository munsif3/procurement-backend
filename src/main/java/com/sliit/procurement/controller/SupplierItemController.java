package com.sliit.procurement.controller;

import com.sliit.procurement.model.SupplierItem;
import com.sliit.procurement.service.SupplierItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Saranki on 11/23/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class SupplierItemController
{
    @Autowired
    SupplierItemService supplierItemService;

    @RequestMapping(value = "/supplierItems")
    public List<SupplierItem> getAllSupplierItems()
    {
        return supplierItemService.getAllSupplierItems();
    }
}
