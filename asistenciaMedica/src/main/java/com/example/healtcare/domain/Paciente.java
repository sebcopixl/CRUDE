package com.example.healtcare.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidad que modela un paciente del mundo real, se registra:
 * <ul>
 *     <li>Código</li>
 *     <li>Nombre</li>
 *     <li>Fecha de Nacimiento</li>
 *     <li>Registro de Signos Vitales</li>
 * </ul>
 */
@Entity
public class Paciente {
    @Id
    @GeneratedValue
    private Long codigo;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeNacimiento;

    @OneToMany(
            mappedBy = "paciente",
            cascade = CascadeType.ALL
    )
    private List<SignosVitales> signosVitalesRegistros;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<SignosVitales> getSignosVitalesRegistros() {
        return signosVitalesRegistros;
    }

    public void setSignosVitalesRegistros(List<SignosVitales> signosVitalesRegistros) {
        this.signosVitalesRegistros = signosVitalesRegistros;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientCode=" + codigo +
                ", name='" + nombre + '\'' +
                ", dateOfBirth=" + fechaDeNacimiento +
                '}';
    }
}
