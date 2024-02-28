package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "id del producto autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Schema(description = "nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ron")
    @Column(nullable = false)
    private String nombre;

    @Schema(description = "referencia del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ron 750ml")
    @Column(nullable = false)
    private String referencia;

    @Schema(description = "cantidad del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @Column(name = "cantidad_stock", nullable = false)
    private double cantidadStock;

    @Schema(description = "precio unitario del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "100000")
    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Schema(description = "Fecha de creacion de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Schema(description = "Fecha de creacion de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Schema(description = "Fecha de creacion de la factura en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    @Column(name = "fecha_eliminacion")
    private LocalDate fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<FacturaModel> facturas;

}
