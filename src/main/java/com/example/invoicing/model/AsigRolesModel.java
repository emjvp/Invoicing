package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "asig_roles")
public class AsigRolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de la asignación de roles autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rol_id")
    private RolModel rol;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;
}
