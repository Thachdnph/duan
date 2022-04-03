package com.example.duan1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;

public class Thongke extends Fragment {
    EditText edtThongKe;
    Button btnThongKe;
    TextView tvThang,tvDoanhThu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thong_ke, container, false);
        edtThongKe = view.findViewById(R.id.edtThongKe);
        btnThongKe = view.findViewById(R.id.btnThongKe);
        tvThang = view.findViewById(R.id.tvThang);
        tvDoanhThu = view.findViewById(R.id.tv_doanhthu);

        return view;
    }

}
