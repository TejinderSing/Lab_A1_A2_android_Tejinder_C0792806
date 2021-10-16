package com.example.lab_a1_a2_android_tejinder_c0792806.db;

import android.content.Context;

import com.example.lab_a1_a2_android_tejinder_c0792806.model.Product;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Provider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Product.class, Provider.class},version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    public static ProductDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    // executor service helps to do tasks in background thread
    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProductDatabase getDbInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class,"products_database").addCallback(sRoomDatabaseCallback).build();
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseWriteExecutor.execute(() -> {
                        ProductDao productDao = INSTANCE.productDao();


                    });
                }
            };
}
