package com.sliit.procurement.service;

import java.util.List;

import com.sliit.procurement.model.Supplier;

public interface SupplierService {

	Supplier getSupplier(int id);
	Supplier addSupplier(Supplier supplier);
	List<Supplier> getAllSuppliers();

}
