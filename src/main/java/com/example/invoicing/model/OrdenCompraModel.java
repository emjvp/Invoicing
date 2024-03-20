package com.example.invoicing.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrdenCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
