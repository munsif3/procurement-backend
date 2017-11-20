package com.sliit.procurement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Saranki on 11/17/2017.
 */

@Entity
@Table(name="purchase_order")
public class PurchaseOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="purchaseNo")
    private int purchaseNo;

    @Column(name="purchaseId")
    private String purchaseId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "requisitionId")
    private requisitionOrder requisitionOrder;

    @Column(name="supplierId")
    private int supplierId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "preparedBy")
    private Employee employee;

    @Column(name="preparedDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date preparedDate;

    @Column(name="amount")
    private Float amount;

    @Column(name="status")
    private String status;

    @Column(name="comments")
    private String comments;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String purchaseId, com.sliit.procurement.model.requisitionOrder requisitionOrder, int supplierId, Employee employee, Date preparedDate, Float amount, String status, String comments) {
        this.purchaseId = purchaseId;
        this.requisitionOrder = requisitionOrder;
        this.supplierId = supplierId;
        this.employee = employee;
        this.preparedDate = preparedDate;
        this.amount = amount;
        this.status = status;
        this.comments = comments;
    }

    public int getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public com.sliit.procurement.model.requisitionOrder getRequisitionOrder() {
        return requisitionOrder;
    }

    public void setRequisitionOrder(com.sliit.procurement.model.requisitionOrder requisitionOrder) {
        this.requisitionOrder = requisitionOrder;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
