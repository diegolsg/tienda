package com.quind.tienda.domain.service;


import com.quind.tienda.domain.interfaceRepository.IPurchaseRepository;
import com.quind.tienda.domain.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private IPurchaseRepository purchaseRepository;
    public List<Purchase> getAll(){
       return purchaseRepository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
