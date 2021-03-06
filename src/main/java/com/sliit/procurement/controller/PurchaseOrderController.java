package com.sliit.procurement.controller;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.GET)
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

//    @ResponseBody
//    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.POST, consumes = "application/json")
//    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
//        return purchaseOrderService.addPurchaseOrder(purchaseOrder);
//    }

    @PostMapping("/purchaseOrders")
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@Valid @RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder = purchaseOrderService.addPurchaseOrder(purchaseOrder);
        purchaseOrder.setPurchaseId("PUR" + String.format("%03d", purchaseOrder.getPurchaseNo()));
        //purchaseOrder.setRequestedBy(4);
        purchaseOrder = purchaseOrderService.addPurchaseOrder(purchaseOrder);
        return new ResponseEntity<PurchaseOrder>(purchaseOrder, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders", method = RequestMethod.PUT)
    public PurchaseOrder updatePurchaseOrder(@RequestBody final PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
    }


//    @ResponseBody
//    @RequestMapping(value = "/purchaseOrders/{purchaseId}", method = RequestMethod.GET)
//    public PurchaseOrder getPurchaseOrderByPurchaseId(@PathVariable String purchaseId)
//    {
//        return purchaseOrderService.getPurchaseOrderByPurchaseId(purchaseId);
//    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders/{status}", method = RequestMethod.GET)
    public List<PurchaseOrder> getPurchaseOrderByStatus(@PathVariable("status")  String status)
    {
        return purchaseOrderService.getPurchaseOrderByStatus(status);
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseOrders/purchaseHistory", method = RequestMethod.GET)
    public List<PurchaseOrder> getOrderByStatus()
    {
        return purchaseOrderService.getOrderByStatus();
    }


//    @ResponseBody
//    @RequestMapping(value = "/purchaseOrders/purchaseNo/{purchaseNo}", method = RequestMethod.GET)
//    public PurchaseOrder getPurchaseOrderByPurchaseNo(@PathVariable("purchaseNo") int purchaseNo){
//        return purchaseOrderService.getPurchaseOrderByPurchaseNo(purchaseNo);
//    }


    @ResponseBody
    @RequestMapping(value = "/purchaseOrders/purchaseId/{purchaseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseOrder getPurchaseOrderByPurchaseNo(@PathVariable("purchaseId") String purchaseId){
        return purchaseOrderService.getPurchaseOrderByPurchaseId(purchaseId);
    }

//
//    @PutMapping("/purchaseOrders")
//    public ResponseEntity<PurchaseOrder>updatePurchaseOrder(@Valid @RequestBody PurchaseOrder purchaseOrder) {
//        PurchaseOrder purchaseOrderOld = purchaseOrderService.getPurchaseOrderByPurchaseNo((purchaseOrder.getPurchaseNo()));
//        Date currentDate = new Date();
//        if(purchaseOrder.getPurchaseId()!=null){
//            purchaseOrderOld.setPurchaseId(purchaseOrder.getPurchaseId());
//        }
//        if(purchaseOrder.getRequestedBy()!=null){
//            purchaseOrderOld.setRequestedBy(purchaseOrder.getRequestedBy());
//        }
//        if(purchaseOrder.getPreparedDate().equals(currentDate)){
//            purchaseOrderOld.setPreparedDate(purchaseOrder.getPreparedDate());
//        }
//        if(purchaseOrder.getPreparedBy().getEmployeeId()!=null){
//            purchaseOrderOld.setPreparedBy(purchaseOrder.getPreparedBy());
//        }
//        if(purchaseOrder.getStatus()!=null){
//            purchaseOrderOld.setStatus(purchaseOrder.getStatus());
//        }
//        if(purchaseOrder.getTotalAmount()!=null){
//            purchaseOrderOld.setTotalAmount(purchaseOrder.getTotalAmount());
//        }
//        purchaseOrderOld=purchaseOrderService.addPurchaseOrder(purchaseOrder);
//        return new ResponseEntity<PurchaseOrder>(purchaseOrderOld,HttpStatus.CREATED);
//    }
}
