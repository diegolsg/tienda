package com.quind.tienda.persistence.repositoryImplement;

import com.quind.tienda.domain.model.Product;
import com.quind.tienda.domain.interfaceRepository.IProductRepository;
import com.quind.tienda.persistence.crud.interfaces.IProductCrudRepository;
import com.quind.tienda.persistence.entity.Producto;
import com.quind.tienda.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepositoryImp implements IProductRepository {
    @Autowired
    private IProductCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return  productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));

    }


   public Product save(Product product){
        Producto producto=mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
   }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }


}
