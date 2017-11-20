package com.sliit.procurement.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Munsif on 11/20/2017.
 */
@Entity
@Table(name = "itemCategory")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryNo")
    private int categoryNo;

    @Column(name = "categoryId")
    private String categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "itemCategory")
    private List<Item> items;

    public ItemCategory() {
    }

    public ItemCategory(String categoryId, String categoryName, String itemDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
