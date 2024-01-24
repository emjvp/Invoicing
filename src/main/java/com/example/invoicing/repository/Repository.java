package com.example.invoicing.repository;

import com.example.invoicing.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<ClienteModel, Long> {

}