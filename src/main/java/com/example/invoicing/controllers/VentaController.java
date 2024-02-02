package com.example.invoicing.controllers;

import com.example.invoicing.models.VentaModel;
import com.example.invoicing.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private VentaRepository ventaRepo;

    @GetMapping("ventas")
    public List<VentaModel> getVentas(){
        return ventaRepo.findAll();
    }
}
