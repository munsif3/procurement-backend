package com.sliit.procurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliit.procurement.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

}
