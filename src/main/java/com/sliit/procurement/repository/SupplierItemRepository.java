package com.sliit.procurement.repository;

import com.sliit.procurement.model.SupplierItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Saranki on 11/23/2017.
 */
public interface SupplierItemRepository extends JpaRepository<SupplierItem, String> {
}
