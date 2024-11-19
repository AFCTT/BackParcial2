package com.finca.arriendo.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato", nullable = false)
    private Tipo tipo; // Tipo de contrato

    @Column(name = "identificador", nullable = false, length = 50)
    private String identificador;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "nombre_contratante", nullable = false, length = 50)
    private String nombreContratante;

    @Column(name = "documento_contratante", nullable = false, length = 50)
    private String documentoContratante;

    @Column(name = "nombre_contratantista", nullable = false, length = 50)
    private String nombreContratantista;

    @Column(name = "documento_contratantista", nullable = false, length = 50)
    private String documentoContratantista;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_final", nullable = false)
    private LocalDate fechaFinal;
}
