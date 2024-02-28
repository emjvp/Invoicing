package com.example.invoicing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column(name = "correo")
    @Getter
    @Setter
    private String email;

    @Column(name = "fecha_nacimiento")
    @Getter
    @Setter
    private LocalDate fechaNacimiento;

    @Transient
    @Getter
    @Setter
    private int edad;

    @Column(name = "fecha_creacion")
    @Getter
    @Setter
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Getter
    @Setter
    private LocalDate fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    @Getter
    @Setter
    private LocalDate fechaEliminacion;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<FacturaModel> facturas;

}
