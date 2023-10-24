package com.quind.tienda.domain.service;

import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.repository.interfaces.IProductRepository;
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
    public Optional<Product> getProducto(int idProducto){
        return productRepository.getProducto(idProducto);
    }
    public Optional<List<Product>> getCategory(int idCategoria) {
        return productRepository.getCategory(idCategoria);
    }
    public Product save(Product producto){
        return productRepository.save(producto);
    }
    public void delete(int idProducto){
        productRepository.delete(idProducto);
    }




}
