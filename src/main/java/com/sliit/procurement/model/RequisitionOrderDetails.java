package com.sliit.procurement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Created by User on 20/11/2017.
 */

@Entity
@Table(name="requisition_order_details")
public class RequisitionOrderDetails implements Serializable{

    @Id
    @Column(name="requisitionNo")
    private int requisitionNo;

    @Id
    @Column(name="itemId")
    private int itemId;

    @Column(name="quantity")
    private Double quantity;

    @Column(name="quantityUnit")
    private String quantityUnit;

    public RequisitionOrderDetails() {
    }

    public RequisitionOrderDetails(int requisitionNo, int itemId, Double quantity, String quantityUnit) {
        this.requisitionNo = requisitionNo;
        this.itemId = itemId;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public int getRequisitionNo() {
        return requisitionNo;
    }

    public void setRequisitionNo(int requisitionNo) {
        this.requisitionNo = requisitionNo;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }
}
