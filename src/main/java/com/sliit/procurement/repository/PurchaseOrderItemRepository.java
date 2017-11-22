package com.sliit.procurement.repository;

import com.sliit.procurement.model.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, String> {
}
