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
@Table(name="clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de cliente autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    @Schema(description = "nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pepe Pérez")
    private String nombre;

    @Column(name = "correo_electronico", nullable = false)
    @Getter
    @Setter
    @Schema(description = "correo del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "example@gmail.com")
    private String email;

    @Column(name = "fecha_nacimiento")
    @Getter
    @Setter
    @Schema(description = "nombre del cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1998-04-10")
    private LocalDate fechaNacimiento;

    @Transient
    @Getter
    @Setter
    @Schema(description = "edad del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "27")
    private int edad;

    @Column(name = "fecha_creacion")
    @Getter
    @Setter
    @Schema(description = "Fecha de creacion del cliente en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Getter
    @Setter
    @Schema(description = "Fecha de actualización del cliente en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    @Getter
    @Setter
    @Schema(description = "Fecha de eliminación del cliente en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<FacturaModel> facturas;

}
