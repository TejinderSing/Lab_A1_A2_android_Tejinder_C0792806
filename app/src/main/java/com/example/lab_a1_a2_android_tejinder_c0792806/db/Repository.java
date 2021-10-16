package com.example.lab_a1_a2_android_tejinder_c0792806.db;

import android.app.Application;

import com.example.lab_a1_a2_android_tejinder_c0792806.model.Product;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Provider;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repository {
    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Provider>> allProviders;

    public Repository(Application application) {
    ProductDatabase db = ProductDatabase.getDbInstance(application);
    productDao = db.productDao();
    allProducts = productDao.getAllProducts();
    allProviders = productDao.getAllProviders();
    }

    public void insertProduct(Product product){
        ProductDatabase.databaseWriteExecutor.execute(() -> productDao.insertProduct(product));
    }

    public void insertProvider(Provider provider){
        ProductDatabase.databaseWriteExecutor.execute(() -> productDao.insertProvider(provider));
    }

    public LiveData<List<Product>> getAllProducts(){return allProducts;}
    public LiveData<List<Provider>> getAllProviders(){return allProviders;}

    public LiveData<List<Product>> getProductsbySearch(String searchKey) {
        return productDao.getProductsbySearch(searchKey);
    }
}
