package com.quind.tienda.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "COMPRAS")
public class Compra {
    @Id
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "id_cliente")
    private String idCliente;
    private LocalDateTime fecha;
    @Column(name = "medio_pago")
    private String medioPago;
    private String comentario;
    private String estado;
    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;
    @ManyToOne
    @JoinColumn (name = "id_cliente",insertable = false,updatable = false)
    private Cliente cliente;

}
