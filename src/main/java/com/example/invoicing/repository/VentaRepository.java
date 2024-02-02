package com.example.invoicing.repository;

import com.example.invoicing.models.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<VentaModel, Long> {
}
