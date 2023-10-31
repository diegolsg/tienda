package com.quind.tienda.presentation.controller;

import com.quind.tienda.domain.model.Purchase;
import com.quind.tienda.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/all")
    public List<Purchase> getAll(){return purchaseService.getAll();}
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return  new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.OK);
    }
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByCliente(@PathVariable("idClinet") String clientId){
        return purchaseService.getByClient(clientId).map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
