package com.example.invoicing.repository;

import com.example.invoicing.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
