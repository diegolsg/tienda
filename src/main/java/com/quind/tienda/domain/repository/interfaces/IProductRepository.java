package com.quind.tienda.domain.repository.interfaces;

import com.quind.tienda.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getCategory(int idCategoria);
    Optional<List<Product>> getProducEscasos(int cantidad);
    Optional<Product> getProducto(int idProducto);
    Product save(Product product);
    void delete(int idProducto);

}
