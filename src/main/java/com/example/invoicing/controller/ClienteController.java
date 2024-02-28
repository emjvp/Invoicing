package com.example.invoicing.controller;


import com.example.invoicing.model.ClienteModel;
import com.example.invoicing.repository.ClienteRepository;
import com.example.invoicing.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private ClienteService clientesSrv;

//    @GetMapping
//    public String index(){
//        return "Conectado";
//    }

    @Operation(summary = "Lista todos los clientes activos en la aplicación", description = "Lista todos los clientes registrados en la aplicación que no tiene un timestamp en la fecha de eliminacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping("clientes")
    public List<ClienteModel> getClientes(){
        return clientesSrv.getClientes();
    }

    @Operation(summary = "Crea un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PostMapping("clientes")
    public String post(@RequestBody ClienteModel clienteModel){
        clientesSrv.createCliente(clienteModel);
        return "Cliente creado";
    }

    @Operation(summary = "Actualiza un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PutMapping("clientes/{id}")
    public String update(@PathVariable Long id, @RequestBody ClienteModel clienteModel){

        clientesSrv.updateCliente(id, clienteModel);

        return "Cliente con id: "+id.toString()+" modificado";
    }

    @Operation(summary = "Elimina un cliente", description = "Oculta un cliente del listado de la api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @DeleteMapping("clientes/{id}")
    public String delete(@PathVariable Long id){
        clientesSrv.deleteCliente(id);
        return "Cliente con id: "+id.toString()+" eliminado";
    }
}
