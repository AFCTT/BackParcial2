package com.finca.arriendo;

import com.finca.arriendo.model.Contrato;
import com.finca.arriendo.model.Tipo;
import com.finca.arriendo.repository.ContratoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContratoRepository contratoRepository;

    public DataLoader(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Datos de prueba para la tabla Contrato
        Contrato contrato1 = new Contrato(
                null,
                Tipo.RENTA,
                "C-001",
                50000.0,
                "Juan Pérez",
                "12345678",
                "María López",
                "87654321",
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));

        Contrato contrato2 = new Contrato(
                null,
                Tipo.COMPRA,
                "C-002",
                120000.0,
                "Carlos Ruiz",
                "22334455",
                "Luisa Fernández",
                "55667788",
                LocalDate.of(2023, 6, 15),
                LocalDate.of(2024, 6, 14));

        Contrato contrato3 = new Contrato(
                null,
                Tipo.RENTA,
                "C-003",
                75000.0,
                "Ana Gómez",
                "33445566",
                "Pedro Méndez",
                "66554433",
                LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 9, 30));

        // Guardar datos en la base de datos
        contratoRepository.saveAll(Arrays.asList(contrato1, contrato2, contrato3));
        System.out.println("Datos de prueba cargados en la base de datos.");
    }
}
