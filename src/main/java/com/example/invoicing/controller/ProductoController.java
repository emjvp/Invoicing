package com.example.invoicing.controller;

import com.example.invoicing.model.ProductoModel;
import com.example.invoicing.repository.ProductoRepository;
import com.example.invoicing.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoSrv;

    @GetMapping("productos")
    public List<ProductoModel> getAllProductos(){
        return productoSrv.getAllProductos();
    }

    @PostMapping("productos")
    public String create(@RequestBody ProductoModel productoModel){
        productoSrv.create(productoModel);
        return "Producto creado";
    }

    @PutMapping("productos/{id}")
    public String update(@PathVariable Long id, @RequestBody ProductoModel productoReqModel){
        productoSrv.update(id, productoReqModel);
        return "Producto con id: "+id.toString()+" actualizado";
    }

    @DeleteMapping("productos/{id}")
    public String delete(@PathVariable Long id){
        productoSrv.delete(id);
        return "Producto con id: "+id.toString()+" eliminado";
    }

}
