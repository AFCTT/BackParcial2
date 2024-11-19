package com.finca.arriendo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finca.arriendo.dto.ContratoDto;
import com.finca.arriendo.services.ContratoService;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<ContratoDto> createContrato(@RequestBody ContratoDto contratoDTO) {
        ContratoDto createdContrato = contratoService.createContrato(contratoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDto> updateContrato(@PathVariable Long id, @RequestBody ContratoDto contratoDTO) {
        ContratoDto updatedContrato = contratoService.updateContrato(id, contratoDTO);
        return ResponseEntity.ok(updatedContrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Long id) {
        contratoService.deleteContrato(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ContratoDto>> getAllContratos() {
        List<ContratoDto> contratos = contratoService.getAllContratos();
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDto> getContratoById(@PathVariable Long id) {
        ContratoDto contratoDTO = contratoService.getContratoById(id);
        return ResponseEntity.ok(contratoDTO);
    }
}
