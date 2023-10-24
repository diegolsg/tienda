package com.quind.tienda.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPRAS_PRODUCTOS")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Producto producto;



}
