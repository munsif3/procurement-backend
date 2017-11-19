package com.sliit.procurement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Saranki on 11/17/2017.
 */

@Entity
@Table(name="purchase_order")
public class PurchaseOrder
{
    @Id
    @Column(name="purchaseNo")
    private int purchaseNo;

    @Column(name="purchaseId")
    private String purchaseId;

    @Column(name="requisitionId")
    private int requisitionId;

    @Column(name="supplierId")
    private int supplierId;

    @Column(name="preparedBy")
    private int preparedBy;

    @Column(name="preparedDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date preparedDate;

    @Column(name="amount")
    private Float amount;

    @Column(name="status")
    private String status;

    @Column(name="comments")
    private String comments;

    public PurchaseOrder()
    {

    }

    public PurchaseOrder(int purchaseNo, String purchaseId, int requisitionId, int supplierId, int preparedBy, Date preparedDate, Float amount, String status, String comments) {
        this.purchaseNo = purchaseNo;
        this.purchaseId = purchaseId;
        this.requisitionId = requisitionId;
        this.supplierId = supplierId;
        this.preparedBy = preparedBy;
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

    public int getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(int requisitionId) {
        this.requisitionId = requisitionId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
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
