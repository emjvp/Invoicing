package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter

@Table(name = "facturas")
public class FacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    private LocalDate fechaEliminacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel producto;

}
