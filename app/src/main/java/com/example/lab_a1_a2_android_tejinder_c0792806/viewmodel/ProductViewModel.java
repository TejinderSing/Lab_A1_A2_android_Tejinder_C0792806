package com.example.lab_a1_a2_android_tejinder_c0792806.viewmodel;

import android.app.Application;

import com.example.lab_a1_a2_android_tejinder_c0792806.db.Repository;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Product;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Provider;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ProductViewModel extends AndroidViewModel {

    private Repository repository;
    private  LiveData<List<Product>> allProducts;
    private final LiveData<List<Provider>> allProviders;

    public ProductViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(application);
        allProducts = repository.getAllProducts();
        allProviders = repository.getAllProviders();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public LiveData<List<Provider>> getAllProviders() {
        return allProviders;
    }

    public LiveData<List<Product>> getProductsbySearch(String searchKey) {
        allProducts = repository.getProductsbySearch(searchKey);
        return allProducts;
    }

    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }

    public void insertProvider(Provider provider) {
        repository.insertProvider(provider);
    }


}
