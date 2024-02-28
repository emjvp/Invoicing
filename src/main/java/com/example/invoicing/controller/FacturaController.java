package com.example.invoicing.controller;

import com.example.invoicing.dto.CrearFacturaDTO;
import com.example.invoicing.model.FacturaModel;
import com.example.invoicing.repository.FacturaRepository;
import com.example.invoicing.service.FacturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Lista todos las facturas activas en la aplicación", description = "Lista todos los clientes registrados en la aplicación que no tiene un timestamp en la fecha de eliminacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping("facturas")
    public List<FacturaModel> getAllFacturas() {
        return facturaSrv.getFacturas();
    }

    @Operation(summary = "Crea cada registro de cada factura", description = "crea cada registro del producto y lo relaciona con el cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PostMapping("facturas")
    // public ResponseEntity<FacturaModel> create(@RequestBody CrearFacturaDTO crearFacturaDTO) {
    public String create(@RequestBody CrearFacturaDTO crearFacturaDTO) {
        FacturaModel facturaModel = facturaSrv.createFactura(crearFacturaDTO);
        // return new ResponseEntity<>(facturaModel, HttpStatus.CREATED);

        return "Factura creada";
    }

    @Operation(summary = "Actualiza cada registro de cada factura", description = "crea cada registro del producto y lo relaciona con el cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PutMapping("facturas/{facturaId}")
    public String update(@PathVariable Long facturaId, @RequestBody CrearFacturaDTO actualizarFactura){
        facturaSrv.updateFactura(facturaId, actualizarFactura);
        return "Factura con id: "+facturaId.toString()+" actualizada";
    }

    @Operation(summary = "Elimina cada registro de una factura", description = "crea cada registro del producto y lo relaciona con el cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operacion realizada con éxito"),
            @ApiResponse(responseCode = "400", description = "parámetros incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @DeleteMapping("facturas/{facturaId}")
    public String delete(@PathVariable Long facturaId) {
        facturaSrv.deleteFactura(facturaId);
        return "Factura con id: "+facturaId.toString()+" eliminada";
    }
}
