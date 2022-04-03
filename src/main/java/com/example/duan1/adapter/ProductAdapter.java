package com.example.duan1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.model.Product;

import java.time.temporal.Temporal;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_product,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText(String.valueOf(products.get(position).getId()));
        holder.tv_pn.setText(products.get(position).getProductName());
        holder.tv_pd.setText(products.get(position).getProductDes());
    }

    @Override
    public int getItemCount() {
        if (products !=null)return products.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id,tv_pn,tv_pd;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.idP);
            tv_pn = itemView.findViewById(R.id.tv_pn);
            tv_pd = itemView.findViewById(R.id.tv_pd);
        }
    }
}
