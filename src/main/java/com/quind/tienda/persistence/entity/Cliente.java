package com.quind.tienda.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "CLIENTES")
public class Cliente {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    @Column(length = 10)
    private Long celular;
    private String direccion;
    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "fecha_nacimiento")
    private LocalDateTime fechaNacimiento;
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

}
