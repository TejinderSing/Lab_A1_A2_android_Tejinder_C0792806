package com.example.lab_a1_a2_android_tejinder_c0792806.db;

import com.example.lab_a1_a2_android_tejinder_c0792806.model.Product;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Provider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;


public interface ProductDao {

    @Insert
    void insertProvider(Provider provider);

    @Insert
    void insertProduct(Product product);

    @Query("SELECT * FROM provider")
    LiveData<List<Provider>> getAllProviders();

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM product WHERE productName LIKE :searchKey || Description LIKE :searchKey")
    public LiveData<List<Product>> getProductsbySearch(String searchKey);



}
