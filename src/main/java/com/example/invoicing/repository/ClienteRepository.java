package com.example.invoicing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<com.example.invoicing.models.Cliente, Long> {
}
