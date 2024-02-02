package com.example.invoicing.controllers;

import com.example.invoicing.models.ClienteModel;
import com.example.invoicing.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UtilsController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Con este método se retornan todos los clientes con sus edades
    @GetMapping("utils/edades-clientes")
    public List<ClienteModel> agesClients(){

        List<ClienteModel> clienteModels = clienteRepository.findAll();
        for (ClienteModel clienteModel : clienteModels) {
            Long idCliente = clienteModel.getId();
            String edad = clienteRepository.findAgeById(idCliente);
            if (edad == null)
            {
                edad = "0";
            }
            clienteModel.setEdad(Integer.parseInt(edad));

        }

        return clienteModels;
    }
}
