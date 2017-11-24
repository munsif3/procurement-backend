package com.sliit.procurement.service;

import com.sliit.procurement.model.SupplierItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saranki on 11/23/2017.
 */

public interface SupplierItemService
{
    List<SupplierItem> getAllSupplierItems();
}
