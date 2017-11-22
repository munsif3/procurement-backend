package com.sliit.procurement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.procurement.Util.CustomErrorType;
import com.sliit.procurement.model.Supplier;
import com.sliit.procurement.model.User;
import com.sliit.procurement.service.SupplierService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/suppliers/", method = RequestMethod.GET)
	public ResponseEntity<List<Supplier>> listAllSuppliers() {
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}
	
	
	@PostMapping("/supplier")
	 public ResponseEntity<Supplier>addUser(@Valid @RequestBody Supplier supplier) {
		 supplier= supplierService.addSupplier(supplier);
		 supplier.setSupplierId("SUP" + String.format("%03d", supplier.getPersonNo()));
		 supplier=supplierService.addSupplier(supplier);
	     return new ResponseEntity<Supplier>(supplier,HttpStatus.CREATED);
	 }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSupplier/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		
		Supplier supplier = supplierService.getSupplier(id);
		if (supplier==null) {
			return new ResponseEntity(new CustomErrorType("Supplier with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	
	@PutMapping("/supplier")
	 public ResponseEntity<Supplier>updateUser(@Valid @RequestBody Supplier supplier) {
		 Supplier supplierOld = supplierService.getSupplier(supplier.getPersonNo());
		 
		 if(supplier.getCompanyName()!=null){
			 supplierOld.setCompanyName(supplier.getCompanyName());
		 }
		 if(supplier.getContractedDate()!=null){
			 supplierOld.setContractedDate(supplier.getContractedDate());
		 }
		 if(supplier.getApproximateDelivaryDays()>0){
			 supplierOld.setApproximateDelivaryDays(supplier.getApproximateDelivaryDays());
		 }
		 if(supplier.getDeliveryChargePercent()>0){
			 supplierOld.setDeliveryChargePercent(supplier.getDeliveryChargePercent());
		 }
		 supplierOld=supplierService.addSupplier(supplierOld);
	     return new ResponseEntity<Supplier>(supplierOld,HttpStatus.CREATED);
	 }
	
}
