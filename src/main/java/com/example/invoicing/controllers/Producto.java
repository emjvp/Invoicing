package com.example.invoicing.controllers;

import com.example.invoicing.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Producto {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("productos")
    public List<com.example.invoicing.models.Producto> getProductos(){
        return productoRepo.findAll();
    }
}
