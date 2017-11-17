package com.sliit.procurement.model;

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
public class Purchase
{
    @Id
    @Column(name="purchaseId")
    private String purchaseId;

    @Column(name="requisitionId")
    private String requisitionId;

    @Column(name="supplierId")
    private String supplierId;

    @Column(name="preparedBy")
    private String preparedBy;

    @Column(name="preparedDate")
    private Date preparedDate;

    @Column(name="status")
    private String status;

    @Column(name="comments")
    private String comments;

    public Purchase()
    {

    }

    public Purchase(String purchaseId, String requisitionId, String supplierId, String preparedBy, Date preparedDate, String status, String comments) {
        this.purchaseId = purchaseId;
        this.requisitionId = requisitionId;
        this.supplierId = supplierId;
        this.preparedBy = preparedBy;
        this.preparedDate = preparedDate;
        this.status = status;
        this.comments = comments;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
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
