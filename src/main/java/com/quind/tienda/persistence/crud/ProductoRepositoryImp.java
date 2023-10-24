package com.quind.tienda.persistence.crud;

import com.quind.tienda.persistence.entity.Producto;

import java.util.List;

public class ProductoRepositoryImp {
    private IProductoCrudRepository productoCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
