package com.example.healtcare.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

/**
 * Entidad que modela los signos vitales de un paciente del mundo real, se registra:
 * <ul>
 *     <li>Código</li>
 *     <li>Nombre</li>
 *     <li>Fecha de Registro</li>
 *     <li>Presión Cardiáca</li>
 *     <li>Frecuencia Cardiáca</li>
 *     <li>Paciente</li>
 * </ul>
 * En este caso se incluye un paciente como atributo de la clase {@link SignosVitales} siendo que un {@link Paciente} puede "poseer"
 * varios signos vitales, pero un {@link SignosVitales} solo puede pertencer a un {@link Paciente}.
 */
@Entity
public class SignosVitales {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRegistro;

    @NotNull
    @PositiveOrZero
    private Float presion;

    @NotNull
    @PositiveOrZero
    private Float frecuencia;

    public SignosVitales() {
    }

    public SignosVitales(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate recordDate) {
        this.fechaRegistro = recordDate;
    }

    public Float getPresion() {
        return presion;
    }

    public void setPresion(Float presion) {
        this.presion = presion;
    }

    public Float getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Float frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Signos Vitales{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", registro=" + fechaRegistro +
                ", presion=" + presion +
                ", frecuencia=" + frecuencia +
                '}';
    }
}
