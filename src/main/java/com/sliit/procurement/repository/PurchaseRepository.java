package com.sliit.procurement.repository;

import com.sliit.procurement.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Saranki on 11/17/2017.
 */

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseOrder,String> {

}
