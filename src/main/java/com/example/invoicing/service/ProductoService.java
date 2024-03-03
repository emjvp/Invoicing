package com.example.invoicing.service;

import com.example.invoicing.model.ProductoModel;
import com.example.invoicing.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepo;

    public List<ProductoModel> getProductos() {
        return productoRepo.findByFechaEliminacion(null);
    }

    public List<ProductoModel> getAllProductos(){
        return productoRepo.findAll();
    }


    @Transactional
    public ProductoModel create(ProductoModel productoModel){
        productoModel.setFechaCreacion(LocalDateTime.now());
        return productoRepo.save(productoModel);
    }

    @Transactional
    public ProductoModel update(@PathVariable Long id, @RequestBody ProductoModel productoReqModel){
        ProductoModel productoToUpdt = productoRepo.findById(id).get();

        productoToUpdt.setNombre(productoReqModel.getNombre());
        productoToUpdt.setCantidadStock(productoReqModel.getCantidadStock());
        productoToUpdt.setReferencia(productoReqModel.getReferencia());
        productoToUpdt.setPrecioUnitario(productoReqModel.getPrecioUnitario());
        productoToUpdt.setFechaActualizacion(LocalDateTime.now());
        return productoRepo.save(productoToUpdt);

    }

    @Transactional
    public void delete(@PathVariable Long id){
        ProductoModel productoModelToDelete = productoRepo.findById(id).get();
        productoModelToDelete.setFechaEliminacion(LocalDateTime.now());
        productoRepo.save(productoModelToDelete);
    }

}
