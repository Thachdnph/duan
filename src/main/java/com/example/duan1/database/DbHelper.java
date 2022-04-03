package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duan1.dao.ProductDAO;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test01";
    private static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String NhanVien = "create table nhanVien (maNv text primary key, hoTen text not null, matKhau text not null)";
        sqLiteDatabase.execSQL(NhanVien);

        //test_thu
        NhanVien ="INSERT INTO nhanVien VALUES ('nv001' ,'tudm02','1111' )";
        sqLiteDatabase.execSQL(NhanVien);
        sqLiteDatabase.execSQL(ProductDAO.CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
