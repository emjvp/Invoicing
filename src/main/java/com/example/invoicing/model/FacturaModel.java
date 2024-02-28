package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "id de factura autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Schema(description = "Fecha de creacion de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Schema(description = "Fecha de actualización de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Schema(description = "Fecha de eliminación de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_eliminacion")
    private LocalDate fechaEliminacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel producto;

}
