package com.example.duan1.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.NhanVien;
import com.example.duan1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PN = "productName";
    public static final String COLUMN_PD = "productDes";
    public static final String TABLE_NAME = "product";
    public static final String CREATE_TABLE_PRODUCT ="CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+"INTEGER AUTOINCREMENT PRIMARY KEY, "+COLUMN_PN+" text, "+COLUMN_PD+" text); ";

    public ProductDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //Them Nhan Vien
    public long insert(Product p) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PN,p.getProductName());
        values.put(COLUMN_PD,p.getProductDes());
        long res = db.insert(TABLE_NAME, null, values);
        return res;
    }


    //get tat ca data
    public List<Product>getAll(){
        String sql ="SELECT * FROM product";
        List<Product> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
            @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex(COLUMN_PN));
            @SuppressLint("Range") String productDes = cursor.getString(cursor.getColumnIndex(COLUMN_PD));
            cursor.moveToNext();
            Product p = new Product();
            p.setId(Integer.parseInt(id));
            p.setProductName(productName);
            p.setProductDes(productDes);
            list.add(p);
        }
        cursor.close();
        return list;
    }
}
