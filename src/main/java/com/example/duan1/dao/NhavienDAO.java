package com.example.duan1.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.duan1.database.DbHelper;
import com.example.duan1.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhavienDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public NhavienDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //Them Nhan Vien
    public long insert(NhanVien nhanVien) {
        ContentValues values = new ContentValues();
        values.put(NhanVien.COL_NAME_maNv, nhanVien.getMaNv());
        values.put(NhanVien.COL_NAME_hoTen, nhanVien.getHoTen());
        values.put(NhanVien.COL_NAME_matKhau, nhanVien.getMatkhau());
        long res = db.insert(NhanVien.TB_NAME, null, values);
        return res;
    }

    //Sua Nhan Vien
    public int update(NhanVien nhanVien) {
        ContentValues values = new ContentValues();
        values.put(NhanVien.COL_NAME_maNv, nhanVien.getMaNv());
        values.put(NhanVien.COL_NAME_hoTen, nhanVien.getHoTen());
        values.put(NhanVien.COL_NAME_matKhau, nhanVien.getMatkhau());
        int res = db.update(NhanVien.TB_NAME, values, "maNv=?", new String[]{nhanVien.getMaNv()});
        return res;
    }
    //Xoa
    public int delete(String id){
        int result = db.delete(NhanVien.TB_NAME,"maNv =?",new String[]{id});
        return result;
    }

    //get data nhieu tham so
    private List<NhanVien> getData(String sql, String... paramater){
        List<NhanVien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,paramater);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            @SuppressLint("Range") String ma = cursor.getString(cursor.getColumnIndex(NhanVien.COL_NAME_maNv));
            @SuppressLint("Range") String ten = cursor.getString(cursor.getColumnIndex(NhanVien.COL_NAME_hoTen));
            @SuppressLint("Range") String matKhau = cursor.getString(cursor.getColumnIndex(NhanVien.COL_NAME_matKhau));
            NhanVien nhanVien = new NhanVien (ma,ten,matKhau);
            list.add(nhanVien);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    //get tat ca data
    public List<NhanVien>getAll(){
        String sql ="SELECT * FROM" + NhanVien.TB_NAME;
        return getData(sql);
    }
    //get data theo id
    public NhanVien getID(String id){
        String sql ="SELECT * FROM nhanVien WHERE maNv=? ";
        List<NhanVien> list = getData(sql,id);
        return list.get(0);
    }
    //check login
    public  int checkLogin(String id, String pass){
        String sql = "SELECT * FROM nhanVien WHERE maNv=? AND matKhau=?";
        List<NhanVien> list = getData(sql,id,pass);
        if (list.size()==0){
            return -1;
        }
        return 1;
    }
}
