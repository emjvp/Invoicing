package com.example.invoicing.controller;

import com.example.invoicing.dto.CrearFacturaDTO;
import com.example.invoicing.model.FacturaModel;
import com.example.invoicing.repository.FacturaRepository;
import com.example.invoicing.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService facturaSrv;

    @Autowired
    FacturaRepository facturaRepo;

//    @GetMapping("facturas")
//    public List<FacturaModel> getFacturas(){
//        return facturaRepo.findAll();
//    }


    @GetMapping("facturas")
    public List<FacturaModel> getAllFacturas() {
        return facturaSrv.getFacturas();
    }

    @PostMapping("facturas")
    // public ResponseEntity<FacturaModel> create(@RequestBody CrearFacturaDTO crearFacturaDTO) {
    public String create(@RequestBody CrearFacturaDTO crearFacturaDTO) {
        FacturaModel facturaModel = facturaSrv.createFactura(crearFacturaDTO);
        // return new ResponseEntity<>(facturaModel, HttpStatus.CREATED);

        return "Factura creada";
    }

    @PutMapping("facturas/{facturaId}")
    public String update(@PathVariable Long facturaId, @RequestBody CrearFacturaDTO actualizarFactura){
        facturaSrv.updateFactura(facturaId, actualizarFactura);
        return "Factura con id: "+facturaId.toString()+" actualizada";
    }

    @DeleteMapping("facturas/{facturaId}")
    public String delete(@PathVariable Long facturaId) {
        facturaSrv.deleteFactura(facturaId);
        return "Factura con id: "+facturaId.toString()+" eliminada";
    }
}
