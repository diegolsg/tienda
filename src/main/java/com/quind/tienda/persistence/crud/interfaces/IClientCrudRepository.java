package com.quind.tienda.persistence.crud.interfaces;


import com.quind.tienda.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClientCrudRepository extends CrudRepository<Cliente,Integer> {
}
