package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.dao.NhavienDAO;
import com.example.duan1.MainActivity;
import com.example.duan1.model.NhanVien;
import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;



public class Add_Tknhanvien extends Fragment {
    private TextInputEditText edUserAddtk;
    private TextInputEditText edHotenAddtk;
    private TextInputEditText edPasswordAddtk;
    private TextInputEditText edNhaplaiPasswordAddtk;
    private Button btnLuuAddtk;
    private Button btnHuyAddtk;
    NhavienDAO dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.add_user, container, false);
        edUserAddtk = view.findViewById(R.id.ed_userName);
        edHotenAddtk = view.findViewById(R.id.ed_fullName);
        edPasswordAddtk = view.findViewById(R.id.ed_newPass);
        edNhaplaiPasswordAddtk = view.findViewById(R.id.ed_rePass);
        btnLuuAddtk = view.findViewById(R.id.btn_luu);
        btnHuyAddtk = view.findViewById(R.id.btn_luu);
        dao = new NhavienDAO(getActivity());
        btnHuyAddtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUserAddtk.setText("");
                edHotenAddtk.setText("");
                edPasswordAddtk.setText("");
                edNhaplaiPasswordAddtk.setText("");
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnLuuAddtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()>0){
                    NhanVien thuThu= new NhanVien();
                    thuThu.setMaNv(edUserAddtk.getText().toString());
                    thuThu.setHoTen(edHotenAddtk.getText().toString());
                    thuThu.setMatkhau(edPasswordAddtk.getText().toString());
                    long result = dao.insert(thuThu);
                    if (result>0){
                        Toast.makeText(getContext(), "Thêm Tài Khoản Thành Công", Toast.LENGTH_SHORT).show();
                        edUserAddtk.setText("");
                        edHotenAddtk.setText("");
                        edPasswordAddtk.setText("");
                        edNhaplaiPasswordAddtk.setText("");
                    }else {
                        Toast.makeText(getContext(), "Thêm Tài Khoản Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
       return view;
    }

    private int validate(){
        int check = 1;
        if (edUserAddtk.getText().toString().isEmpty()||edHotenAddtk.toString().isEmpty()||edPasswordAddtk.getText().toString().isEmpty()||edNhaplaiPasswordAddtk.getText().toString().isEmpty()){
            Toast.makeText(getContext(), "Bạn Phải Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
            check=-1;
        }else {
            String pass = edPasswordAddtk.getText().toString();
            String repass = edNhaplaiPasswordAddtk.getText().toString();
            if (!pass.equals(repass)) {
                Toast.makeText(getContext(), "Mật Khẩu nhập Lại Khôn Khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }
        }
        return check;
    }
}
