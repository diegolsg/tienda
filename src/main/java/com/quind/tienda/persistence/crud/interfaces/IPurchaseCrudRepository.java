package com.quind.tienda.persistence.crud.interfaces;

import com.quind.tienda.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends CrudRepository<Compra,Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
