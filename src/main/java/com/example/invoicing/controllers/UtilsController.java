package com.example.invoicing.controllers;

import com.example.invoicing.models.Cliente;
import com.example.invoicing.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
public class UtilsController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Con este método se retornan todos los clientes con sus edades
    @GetMapping("utils/edades-clientes")
    public List<Cliente> agesClients(){

        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente: clientes) {
            Long idCliente = cliente.getId();
            String edad = clienteRepository.findAgeById(idCliente);
            if (edad == null)
            {
                edad = "0";
            }
            cliente.setEdad(Integer.parseInt(edad));

        }

        return clientes;
    }
}
