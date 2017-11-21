package com.sliit.procurement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "purchase_order_item", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderItem.findAll", query = "SELECT p FROM PurchaseOrderItem p")
    , @NamedQuery(name = "PurchaseOrderItem.findByPurchaseNo", query = "SELECT p FROM PurchaseOrderItem p WHERE p.purchaseOrderItemPK.purchaseNo = :purchaseNo")
    , @NamedQuery(name = "PurchaseOrderItem.findByItemNo", query = "SELECT p FROM PurchaseOrderItem p WHERE p.purchaseOrderItemPK.itemNo = :itemNo")
    , @NamedQuery(name = "PurchaseOrderItem.findByOrderedQuantity", query = "SELECT p FROM PurchaseOrderItem p WHERE p.orderedQuantity = :orderedQuantity")
    , @NamedQuery(name = "PurchaseOrderItem.findBySubTotal", query = "SELECT p FROM PurchaseOrderItem p WHERE p.subTotal = :subTotal")})
public class PurchaseOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PurchaseOrderItemPK purchaseOrderItemPK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orderedQuantity")
    private Float orderedQuantity;

    @Column(name = "subTotal")
    private Float subTotal;

    @JoinColumn(name = "itemNo", referencedColumnName = "itemNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    @JoinColumn(name = "purchaseNo", referencedColumnName = "purchaseNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrder;

    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(PurchaseOrderItemPK purchaseOrderItemPK) {
        this.purchaseOrderItemPK = purchaseOrderItemPK;
    }

    public PurchaseOrderItem(int purchaseNo, int itemNo) {
        this.purchaseOrderItemPK = new PurchaseOrderItemPK(purchaseNo, itemNo);
    }

    public PurchaseOrderItemPK getPurchaseOrderItemPK() {
        return purchaseOrderItemPK;
    }

    public void setPurchaseOrderItemPK(PurchaseOrderItemPK purchaseOrderItemPK) {
        this.purchaseOrderItemPK = purchaseOrderItemPK;
    }

    public Float getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Float orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderItemPK != null ? purchaseOrderItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderItem)) {
            return false;
        }
        PurchaseOrderItem other = (PurchaseOrderItem) object;
        if ((this.purchaseOrderItemPK == null && other.purchaseOrderItemPK != null) || (this.purchaseOrderItemPK != null && !this.purchaseOrderItemPK.equals(other.purchaseOrderItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.PurchaseOrderItem[ purchaseOrderItemPK=" + purchaseOrderItemPK + " ]";
    }
    
}
