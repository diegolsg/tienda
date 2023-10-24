package com.quind.tienda.domain.model;

import lombok.Data;

@Data
public class Product {
    private  int idProduct;
    private String name;
    private int categoryId;
    private double price;
    private int Stock;
    private boolean active;
    private Category category;
}
