package com.quind.tienda.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @Column(name = "id_producto")
    private  Integer idProducto;
    private String nombre;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double pecioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;
    @ManyToMany
    @JoinColumn(name = "id_categoria", insertable = false,updatable = false)
    private Categoria categoria;
}
