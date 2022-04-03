package com.example.duan1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.adapter.NhanVien_Adapter;
import com.example.duan1.dao.NhavienDAO;
import com.example.duan1.R;


public class Qly_TKnhanvien extends Fragment {
        ListView lv_nhanvien;
        NhavienDAO dao;
        NhanVien_Adapter nhanVien_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.danhsach_nhanvien, container, false);
       lv_nhanvien = view.findViewById(R.id.lv_nhanvien);
       dao = new  NhavienDAO(getActivity());
       return view;
    }
}
