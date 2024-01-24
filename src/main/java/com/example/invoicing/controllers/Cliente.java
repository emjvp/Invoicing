package com.example.invoicing.controllers;


import com.example.invoicing.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Cliente {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<com.example.invoicing.models.Cliente> getClientes(){
        return clienteRepo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody com.example.invoicing.models.Cliente cliente){
        clienteRepo.save(cliente);
        return "Guardado";
    }

    @PutMapping("modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody com.example.invoicing.models.Cliente cliente){
        com.example.invoicing.models.Cliente updateCliente = clienteRepo.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        clienteRepo.save(updateCliente);

        return "Modificado";
    }
}
