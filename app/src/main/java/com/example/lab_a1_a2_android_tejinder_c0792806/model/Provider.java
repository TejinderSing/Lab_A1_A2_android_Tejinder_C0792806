package com.example.lab_a1_a2_android_tejinder_c0792806.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "provider")
public class Provider {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "providerID")
    private String providerID;

    @NonNull
    @ColumnInfo(name = "providerName")
    private String providerName;

    @NonNull
    @ColumnInfo(name = "providerEmail")
    private String providerEmail;

    @NonNull
    @ColumnInfo(name = "providerPhone")
    private String providerPhone;

    @NonNull
    @ColumnInfo(name = "providerLongitutde")
    private Double providerLongitutde;

    @NonNull
    @ColumnInfo(name = "providerLatitude")
    private Double providerLatitude;

    public Provider() {
    }

    public Provider(String providerID, @NonNull String providerName, @NonNull String providerEmail, String providerPhone, @NonNull Double providerLongitutde, @NonNull Double providerLatitude) {
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerEmail = providerEmail;
        this.providerPhone = providerPhone;
        this.providerLongitutde = providerLongitutde;
        this.providerLatitude = providerLatitude;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    @NonNull
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(@NonNull String providerName) {
        this.providerName = providerName;
    }

    @NonNull
    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(@NonNull String providerEmail) {
        this.providerEmail = providerEmail;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    @NonNull
    public Double getProviderLongitutde() {
        return providerLongitutde;
    }

    public void setProviderLongitutde(@NonNull Double providerLongitutde) {
        this.providerLongitutde = providerLongitutde;
    }

    @NonNull
    public Double getProviderLatitude() {
        return providerLatitude;
    }

    public void setProviderLatitude(@NonNull Double providerLatitude) {
        this.providerLatitude = providerLatitude;
    }
}
