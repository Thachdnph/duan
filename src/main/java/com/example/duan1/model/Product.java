package com.example.duan1.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    Integer id;
    String productName;
    String productDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public Product( String productName, String productDes) {
        this.productName = productName;
        this.productDes = productDes;
    }

    public Product() {
    }

}
