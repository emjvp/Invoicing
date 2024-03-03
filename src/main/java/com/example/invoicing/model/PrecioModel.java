package com.example.invoicing.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "precios")
public class PrecioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de los preios autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Schema(description = "valor del precio", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    private double valor;

    @Schema(description = "Fecha de inicio del precio", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Schema(description = "Fecha de final del precio", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Schema(description = "Fecha de creación del precio", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Schema(description = "Fecha de actualización del precio", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Schema(description = "Fecha de eliminación del precio", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;

}
