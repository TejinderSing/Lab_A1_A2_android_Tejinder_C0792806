package com.example.lab_a1_a2_android_tejinder_c0792806.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "product" , foreignKeys = @ForeignKey(entity = Provider.class, parentColumns = "providerID",childColumns = "productProviderID", onDelete = CASCADE))
public class Product {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "productID")
    private String productID;

    @NonNull
    private String productProviderID;
    @NonNull
    @ColumnInfo(name = "productName")
    private String productName;

    @NonNull
    @ColumnInfo(name = "productPrice")
    private int productPrice;

    @NonNull
    @ColumnInfo(name = "Description")
    private String prodcutDesc;

    public Product() {
    }

    public Product(String productID, @NonNull String productProviderID, @NonNull String productName, int productPrice, @NonNull String prodcutDesc) {
        this.productID = productID;
        this.productProviderID = productProviderID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.prodcutDesc = prodcutDesc;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @NonNull
    public String getProductProviderID() {
        return productProviderID;
    }

    public void setProductProviderID(@NonNull String productProviderID) {
        this.productProviderID = productProviderID;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @NonNull
    public String getProdcutDesc() {
        return prodcutDesc;
    }

    public void setProdcutDesc(@NonNull String prodcutDesc) {
        this.prodcutDesc = prodcutDesc;
    }
}
