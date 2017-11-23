package com.sliit.procurement.repository;

import com.sliit.procurement.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> {

    List<PurchaseOrder> findByStatus(String status);

    PurchaseOrder findByPurchaseNo(int purchaseNo);

    PurchaseOrder findByPurchaseId(String purchaseId);

}
