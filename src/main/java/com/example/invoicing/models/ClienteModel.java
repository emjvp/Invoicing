package com.example.invoicing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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

}
