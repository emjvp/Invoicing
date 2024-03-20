package com.example.invoicing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// @Entity
@Getter
@Setter
@Table(name = "compras")
public class ComprasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_comprada")
    private Long cantidadComprada;



}
