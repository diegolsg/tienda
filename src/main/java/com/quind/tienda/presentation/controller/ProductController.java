package com.quind.tienda.presentation.controller;


import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
   public List<Product> getAll(){
       return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElse(new
                ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")int productId){
        return productService.delete(productId);}
    @PostMapping("/save")
    public  Product save(@RequestBody Product product){
        return  productService.save(product);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return  productService.getByCategory(categoryId);
    }
}
