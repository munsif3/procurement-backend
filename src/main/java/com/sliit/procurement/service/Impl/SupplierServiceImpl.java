package com.sliit.procurement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliit.procurement.model.Supplier;
import com.sliit.procurement.repository.SupplierRepository;
import com.sliit.procurement.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public Supplier getSupplier(int id) {
		return supplierRepository.findOne(id);
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

}
