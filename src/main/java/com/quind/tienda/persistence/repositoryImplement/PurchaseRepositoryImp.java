package com.quind.tienda.persistence.repositoryImplement;


import com.quind.tienda.domain.interfaceRepository.IPurchaseRepository;
import com.quind.tienda.domain.model.Purchase;
import com.quind.tienda.persistence.crud.interfaces.IPurchaseCrudRepository;
import com.quind.tienda.persistence.entity.Compra;
import com.quind.tienda.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImp implements IPurchaseRepository {
    @Autowired
    private IPurchaseCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

   public List<Purchase> getAll(){
       return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return compraCrudRepository.findByIdCliente(clientId).map
                (compras -> mapper.toPurchases(compras));
    }
    public Purchase save(Purchase purchase){
        Compra compra=mapper.toCompra(purchase);
        compra.getComprasProductos().forEach(producto-> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }


}
