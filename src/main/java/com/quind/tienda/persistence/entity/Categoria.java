package com.quind.tienda.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "CATEGORIAS")
public class Categoria {
    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
