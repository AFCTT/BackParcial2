package com.finca.arriendo.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.finca.arriendo.dto.ContratoDto;
import com.finca.arriendo.model.Contrato;
import com.finca.arriendo.model.Contrato;
import com.finca.arriendo.repository.ContratoRepository;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;
    private final ModelMapper modelMapper;

    public ContratoService(ContratoRepository contratoRepository, ModelMapper modelMapper) {
        this.contratoRepository = contratoRepository;
        this.modelMapper = modelMapper;
    }

    public ContratoDto createContrato(ContratoDto contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato savedContrato = contratoRepository.save(contrato);// con esto se crea el contrato y lo guarda en la
                                                                   // base de datos h2
        return modelMapper.map(savedContrato, ContratoDto.class);
    }

    public ContratoDto updateContrato(Long id, ContratoDto contratoDTO) {// actualiza el contrato
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));// si no encuentra registro por
                                                                                   // identificador, lanza una exepcion
                                                                                   // y no lo actualiza
        modelMapper.map(contratoDTO, contrato);
        Contrato updatedContrato = contratoRepository.save(contrato);// ahora si lo encuentra lo actualiza
        return modelMapper.map(updatedContrato, ContratoDto.class);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);// se borra por el id ya que es una llave primaria
    }

    public List<ContratoDto> getAllContratos() {
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDto.class))// TRae todos los contratos y los mapea a
                                                                              // ContratoDto
                .toList();
    }

    public ContratoDto getContratoById(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));// lo mismo que en update si no
                                                                                   // encuentra el contrato lo lanza una
                                                                                   // exepcion y no lo muestra
        return modelMapper.map(contrato, ContratoDto.class);
    }
}
