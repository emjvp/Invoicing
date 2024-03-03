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
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de usuario autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "nomre del usuario", requiredMode = Schema.RequiredMode.REQUIRED, example = "Usuario test")
    private String nombre;

    @Column(name = "correo_electronico", nullable = false)
    @Schema(description = "Correo electrónico del usuario", requiredMode = Schema.RequiredMode.REQUIRED, example = "example@gmail.com")
    private String email;

    @Column(nullable = false)
    @Schema(description = "contrasenia", requiredMode = Schema.RequiredMode.REQUIRED, example = "admin123")
    private String contrasenia;

    @Column(name = "fecha_creacion")
    @Schema(description = "Fecha de creación del usuario en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Schema(description = "Fecha de creación del usuario en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    @Schema(description = "Fecha de eliminación del usuario en la bd", requiredMode = Schema.RequiredMode.AUTO, example = "2024-02-28")
    private LocalDateTime fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "asig_usuarios", cascade = CascadeType.PERSIST)
    private List<AsigRolesModel> asignacionUsuarios;


}
