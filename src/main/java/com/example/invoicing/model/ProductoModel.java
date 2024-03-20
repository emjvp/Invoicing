package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id del producto autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Schema(description = "nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ron")
    @Column(nullable = false)
    private String nombre;

    @Schema(description = "referencia del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ron 750ml")
    @Column(nullable = false)
    private String referencia;

    @Schema(description = "Costo unitario del producto comprado sin el sobrecosto", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @Column(name = "costo_unitario", nullable = false)
    private double costoUnitario;

    @Schema(description = "Número de lote del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "100000")
    @Column(name = "numero_lote", nullable = false)
    private String numeroLote;

    @Schema(description = "Fecha de creación del producto en la bd", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Schema(description = "Fecha de actualización del prducto en la bd", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Schema(description = "Fecha de eliminación del producto en la bd", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST)
    private List<FacturaModel> facturas;

}
