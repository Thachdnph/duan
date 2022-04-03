package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.R;
import com.example.duan1.adapter.ProductAdapter;
import com.example.duan1.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Qly_SanPham#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Qly_SanPham extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Qly_SanPham() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Qly_SanPham.
     */
    // TODO: Rename and change types and number of parameters
    public static Qly_SanPham newInstance(String param1, String param2) {
        Qly_SanPham fragment = new Qly_SanPham();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_qly_san_pham, container, false);
    }
    Product p;
    RecyclerView rcv;
    ProductAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        p = new Product();
        List<Product> ps = new ArrayList<>();
        ps.add(new Product("p1","des p1"));
        ps.add(new Product("p2","des p2"));
        ps.add(new Product("p3","des p3"));
        ps.add(new Product("p4","des p4"));
        ps.add(new Product("p5","des p5"));
        ps.add(new Product("p6","des p6"));
        rcv = view.findViewById(R.id.rcv_listProduct);
        adapter = new ProductAdapter();
        adapter.setProducts(ps);
        rcv.setAdapter(adapter);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}