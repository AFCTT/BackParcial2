package com.finca.arriendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finca.arriendo.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
