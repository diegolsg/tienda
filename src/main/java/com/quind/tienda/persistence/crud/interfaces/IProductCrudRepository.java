package com.quind.tienda.persistence.crud.interfaces;

import com.quind.tienda.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface IProductCrudRepository extends CrudRepository<Producto,Integer>{
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
