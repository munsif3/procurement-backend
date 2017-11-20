package com.sliit.procurement.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Munsif on 11/21/2017.
 */
@Entity
@Table(name = "item_supplier")
public class ItemSupplier implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "itemNo")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
