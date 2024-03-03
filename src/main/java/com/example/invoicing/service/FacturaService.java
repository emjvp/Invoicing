package com.example.invoicing.service;

import com.example.invoicing.dto.CrearFacturaDTO;
import com.example.invoicing.model.ClienteModel;
import com.example.invoicing.model.FacturaModel;
import com.example.invoicing.model.ProductoModel;
import com.example.invoicing.repository.ClienteRepository;
import com.example.invoicing.repository.FacturaRepository;
import com.example.invoicing.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepo;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<FacturaModel> getFacturas(){
        return facturaRepo.findByFechaEliminacion(null);
    }
    public List<FacturaModel> getAllFacturas() {
        return facturaRepo.findAll();
    }

    @Transactional
    public FacturaModel createFactura(CrearFacturaDTO crearFacturaDTO){
        ClienteModel cliente = clienteRepository.findById(crearFacturaDTO.getClienteId())
                .get();

        ProductoModel producto = productoRepository.findById(crearFacturaDTO.getProductoId())
                .get();


        FacturaModel factura = new FacturaModel();

        factura.setCliente(cliente);

        producto.setCantidadStock( producto.getCantidadStock() - 1 );
        factura.setProducto(producto);
        factura.setFechaCreacion(LocalDateTime.now());

        return facturaRepo.save(factura);
    }

    @Transactional
    public FacturaModel updateFactura(Long facturaId, CrearFacturaDTO crearFacturaDTO){
        FacturaModel facturaToUpdate = facturaRepo.findById(facturaId).get();
        ClienteModel cliente = clienteRepository.findById(crearFacturaDTO.getClienteId())
                .get();

        ProductoModel producto = productoRepository.findById(crearFacturaDTO.getProductoId())
                .get();

        facturaToUpdate.setCliente(cliente);
        facturaToUpdate.setProducto(producto);
        facturaToUpdate.setFechaActualizacion(LocalDateTime.now());

        return facturaRepo.save(facturaToUpdate);
    }

    @Transactional
    public void deleteFactura(Long facturaId){

        FacturaModel facturaToDelete = facturaRepo.findById(facturaId).get();
        facturaToDelete.setFechaEliminacion(LocalDateTime.now());
        facturaRepo.save(facturaToDelete);

    }

}
