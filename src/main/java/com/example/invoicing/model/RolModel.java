package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de rol autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "nomre del rol", requiredMode = Schema.RequiredMode.REQUIRED, example = "Usuario test")
    private String nombre;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "asig_usuarios", cascade = CascadeType.PERSIST)
    private List<AsigRolesModel> asignacionUsuarios;
}
