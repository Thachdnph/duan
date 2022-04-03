package com.example.duan1.model;

public class NhanVien {
    String maNv;
    String hoTen;
    String matkhau;

    public static final String TB_NAME = "nhanVien";
    public static final String COL_NAME_maNv = "maNv";
    public static final String COL_NAME_hoTen = "hoTen";
    public static final String COL_NAME_matKhau = "matKhau";

    public NhanVien() {
    }

    public NhanVien(String maNv, String hoTen, String matkhau) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.matkhau = matkhau;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
