package com.example.invoicing.repository;

import com.example.invoicing.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public interface ClienteRepository extends JpaRepository<com.example.invoicing.models.Cliente, Long> {

    // Definí un método aquí en el repositorio del cliente

    /*
    @Query(value = "SELECT *, FLOOR(DATEDIFF(NOW(), fecha_nacimiento) / 365) AS edad FROM clientes", nativeQuery = true)
    List<Object[]> findAllClientsAge();
    */

    @Query(value = "SELECT FLOOR(DATEDIFF(NOW(), fecha_nacimiento) / 365) AS edad_calculada FROM clientes WHERE id = :id", nativeQuery = true)
    String findAgeById(@Param("id") Long id);

}
