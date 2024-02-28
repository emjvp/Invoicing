package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String referencia;

    @Column(name = "cantidad_stock")
    private int cantidadStock;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    private LocalDate fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<FacturaModel> facturas;

}
