package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.SupplierItem;
import com.sliit.procurement.repository.SupplierItemRepository;
import com.sliit.procurement.service.SupplierItemService;
import com.sliit.procurement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saranki on 11/23/2017.
 */
@Service
public class SupplierItemServiceImpl implements SupplierItemService
{
    @Autowired
    SupplierItemRepository supplierItemRepository;


    @Override
    public List<SupplierItem> getAllSupplierItems() {
        return supplierItemRepository.findAll();
    }
}
