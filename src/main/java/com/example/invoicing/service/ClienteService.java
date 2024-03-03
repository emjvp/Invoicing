package com.example.invoicing.service;

import com.example.invoicing.model.ClienteModel;
import com.example.invoicing.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    public List<ClienteModel> getClientes() {
        return clienteRepo.findByFechaEliminacion(null);
    }

    public List<ClienteModel> getAllClientes() {
        return clienteRepo.findAll();
    }

    @Transactional
    public ClienteModel createCliente(@RequestBody ClienteModel clienteModel){
        clienteModel.setFechaCreacion(LocalDateTime.now());
        return clienteRepo.save(clienteModel);
    }

    @Transactional
    public ClienteModel updateCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        // TODO: para actualizar los otros datos de los clientes (fecha actualización, fecha eliminación) SÓLO lo puede hacer un administrador y con una descripción de porqué se cambia en los casos de la fecha de actualización y eliminación

        ClienteModel clienteToUpdate = clienteRepo.findById(id).get();
        clienteToUpdate.setNombre(clienteModel.getNombre());
        clienteToUpdate.setEmail(clienteModel.getEmail());
        clienteToUpdate.setFechaNacimiento(clienteModel.getFechaNacimiento());
        clienteToUpdate.setFechaActualizacion(LocalDateTime.now());

        return clienteRepo.save(clienteToUpdate);
    }

    @Transactional
    public void deleteCliente(@PathVariable Long id){
        ClienteModel deleteCliente = clienteRepo.findById(id).get();

        deleteCliente.setFechaEliminacion(LocalDateTime.now());

        clienteRepo.save(deleteCliente);
    }
}
