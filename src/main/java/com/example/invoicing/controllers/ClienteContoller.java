package com.example.invoicing.controllers;


import com.example.invoicing.models.ClienteModel;
import com.example.invoicing.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteContoller {

    @Autowired
    private Repository repo;

    @GetMapping
    public String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<ClienteModel> getClientes(){
        return repo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody ClienteModel cliente){
        repo.save(cliente);
        return "Guardado";
    }

    @PutMapping("modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody ClienteModel cliente){
        ClienteModel updateCliente = repo.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        repo.save(updateCliente);

        return "Modificado";
    }
}
