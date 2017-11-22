package com.sliit.procurement.repository;

import com.sliit.procurement.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> {
}
