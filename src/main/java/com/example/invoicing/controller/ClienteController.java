package com.example.invoicing.controller;


import com.example.invoicing.model.ClienteModel;
import com.example.invoicing.repository.ClienteRepository;
import com.example.invoicing.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
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

    // @Operation(summary = "Lista todos los clientes", description = "Lista todos los clientes registrados en la aplicación")
    @GetMapping("clientes")
    public List<ClienteModel> getClientes(){
        return clientesSrv.getClientes();
    }

    @PostMapping("clientes")
    public String post(@RequestBody ClienteModel clienteModel){
        clientesSrv.createCliente(clienteModel);
        return "Cliente creado";
    }

    @PutMapping("clientes/{id}")
    public String update(@PathVariable Long id, @RequestBody ClienteModel clienteModel){

        clientesSrv.updateCliente(id, clienteModel);

        return "Cliente con id: "+id.toString()+" modificado";
    }

    @DeleteMapping("clientes/{id}")
    public String delete(@PathVariable Long id){
        clientesSrv.deleteCliente(id);
        return "Cliente con id: "+id.toString()+" eliminado";
    }
}
