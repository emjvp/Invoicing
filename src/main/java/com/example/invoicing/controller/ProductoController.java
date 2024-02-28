package com.example.invoicing.controller;

import com.example.invoicing.model.ProductoModel;
import com.example.invoicing.repository.ProductoRepository;
import com.example.invoicing.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoSrv;

    @Operation(summary = "Lista todos los prpductos activos", description = "Lista todos los prpductos sin eliminar de la aplicación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping("productos")
    public List<ProductoModel> getAllProductos(){
        return productoSrv.getProductos();
    }

    @Operation(summary = "Crea el producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PostMapping("productos")
    public String create(@RequestBody ProductoModel productoModel){
        productoSrv.create(productoModel);
        return "Producto creado";
    }

    @Operation(summary = "Actualiza un pruducto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PutMapping("productos/{id}")
    public String update(@PathVariable Long id, @RequestBody ProductoModel productoReqModel){
        productoSrv.update(id, productoReqModel);
        return "Producto con id: "+id.toString()+" actualizado";
    }

    @Operation(summary = "Elimina un producto", description = "Oculta un producto del listado de la api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @DeleteMapping("productos/{id}")
    public String delete(@PathVariable Long id){
        productoSrv.delete(id);
        return "Producto con id: "+id.toString()+" eliminado";
    }

}
