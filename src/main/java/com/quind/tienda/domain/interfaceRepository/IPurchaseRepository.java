package com.quind.tienda.domain.interfaceRepository;

import com.quind.tienda.domain.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
