package com.example.invoicing.repository;

import com.example.invoicing.model.FacturaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FacturaRepository extends JpaRepository<FacturaModel, Long> {
    List<FacturaModel> findByFechaEliminacion(LocalDate fechaEliminacion);
}
