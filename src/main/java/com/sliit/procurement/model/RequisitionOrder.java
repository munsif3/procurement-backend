package com.sliit.procurement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 20/11/2017.
 */

@Entity
@Table(name="requisition_order")
public class requisitionOrder {

    @Id
    @Column(name="requisitionNo")
    private int requisitionNo;

    @Column(name="requisitionId")
    private String requisitionId;

    @Column(name="orderBy")
    private int orderBy;

    @Column(name="reqOrderedDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reqOrderedDate;

    @Column(name="reqExpectedDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reqExpectedDate;

    @Column(name="status")
    private String status;

    @Column(name="comments")
    private String comments;

    @OneToMany(mappedBy = "requisition_order")
    private List<PurchaseOrder> purchaseOrder;

    public requisitionOrder() {
    }

    public requisitionOrder(int requisitionNo, String requisitionId, int orderBy, Date reqOrderedDate, Date reqExpectedDate, String status, String comments) {
        this.requisitionNo = requisitionNo;
        this.requisitionId = requisitionId;
        this.orderBy = orderBy;
        this.reqOrderedDate = reqOrderedDate;
        this.reqExpectedDate = reqExpectedDate;
        this.status = status;
        this.comments = comments;
    }

    public int getRequisitionNo() {
        return requisitionNo;
    }

    public void setRequisitionNo(int requisitionNo) {
        this.requisitionNo = requisitionNo;
    }

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public Date getReqOrderedDate() {
        return reqOrderedDate;
    }

    public void setReqOrderedDate(Date reqOrderedDate) {
        this.reqOrderedDate = reqOrderedDate;
    }

    public Date getReqExpectedDate() {
        return reqExpectedDate;
    }

    public void setReqExpectedDate(Date reqExpectedDate) {
        this.reqExpectedDate = reqExpectedDate;
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
