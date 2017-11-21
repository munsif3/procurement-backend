package com.sliit.procurement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
    @JoinColumn(name = "requisitionNo")
    private RequisitionOrder RequisitionOrder;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;

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

   /* @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseOrderDetails> purchaseOrderDetails;*/

    public PurchaseOrder() {
    }

    public PurchaseOrder(String purchaseId, com.sliit.procurement.model.RequisitionOrder requisitionOrder, Supplier supplier, Employee employee, Date preparedDate, Float amount, String status, String comments) {
        this.purchaseId = purchaseId;
        RequisitionOrder = requisitionOrder;
        this.supplier = supplier;
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

    public com.sliit.procurement.model.RequisitionOrder getRequisitionOrder() {
        return RequisitionOrder;
    }

    public void setRequisitionOrder(com.sliit.procurement.model.RequisitionOrder requisitionOrder) {
        RequisitionOrder = requisitionOrder;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
