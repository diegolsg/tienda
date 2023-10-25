package com.quind.tienda.persistence.crud;

import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.repository.interfaces.IProductRepository;
import com.quind.tienda.persistence.entity.Producto;
import com.quind.tienda.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepositoryImp  implements IProductRepository {
    private IProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    public Optional<List<Product>> getCategory(int idCategoria){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }

   public  Optional<Product> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
   }
   public Product save(Product product){
        Producto producto=mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
   }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
    public Optional<List<Product>> getProducEscasos(int cantidad){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
        return productos.map(prods ->mapper.toProducts(prods));
    }
}
