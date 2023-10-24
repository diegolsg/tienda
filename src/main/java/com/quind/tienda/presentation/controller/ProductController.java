package com.quind.tienda.presentation.controller;

import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService productService;
    public List<Product> getAll(){
        return productService.getAll();
    }
}
