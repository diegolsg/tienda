package com.quind.tienda.domain.service;

import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.interfaceRepository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    public List<Product> getAll(){
       return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId) {

        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;}).orElse(false);
    }




}
