package com.example.invoicing.controllers;


import com.example.invoicing.models.ClienteModel;
import com.example.invoicing.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<ClienteModel> getClientes(){
        return clienteRepo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody ClienteModel clienteModel){
        clienteRepo.save(clienteModel);
        return "Guardado";
    }

    @PutMapping("modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        ClienteModel updateCliente = clienteRepo.findById(id).get();
        updateCliente.setNombre(clienteModel.getNombre());
        updateCliente.setEmail(clienteModel.getEmail());
        clienteRepo.save(updateCliente);

        return "Modificado";
    }

    @DeleteMapping("baja/{id}")
    public String delete(@PathVariable Long id){
        ClienteModel deleteCliente = clienteRepo.findById(id).get();
        clienteRepo.delete(deleteCliente);
        return "Eliminado";
    }
}
