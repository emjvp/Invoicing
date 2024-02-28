package com.example.invoicing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearFacturaDTO {
    private Long clienteId;
    private Long productoId;

}
