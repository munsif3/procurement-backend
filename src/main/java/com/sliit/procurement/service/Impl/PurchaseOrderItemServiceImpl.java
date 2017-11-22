package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.PurchaseOrderItem;
import com.sliit.procurement.repository.PurchaseOrderItemRepository;
import com.sliit.procurement.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 22/11/2017.
 */

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

    @Autowired
    PurchaseOrderItemRepository purchaseOrderItemRepository;

    @Override
    public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }
}
