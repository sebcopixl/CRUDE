package com.example.healtcare.service;

import com.example.healtcare.domain.Paciente;

import java.util.List;

/**
 * Interfaz del service de la entidad {@link Paciente}
 * <p>
 * Todas las operaciones relacionadas a la lógica de negocio de un {@link Paciente} deben ser procesadas por esta clase
 */
public interface IPacienteService {
    /**
     * Lista todos los pacientes
     *
     * @return lista de pacientes
     */
    List<Paciente> listarPaciente();

    /**
     * Guarda un paciente
     *
     * @param paciente objeto paciente para almacenar
     */
    void guardar(Paciente paciente);

    /**
     * Elimina un paciente por medio de su código
     *
     * @param codigo código del paciente para eliminar
     */
    void eliminar(Long codigo);

    /**
     * Busca un paciente por el códigod del paciente
     *
     * @param codigo codigo del paciente para buscar
     * @return Paciente encontrado por el código
     */
    Paciente getPacienteByCodigo(Long codigo);
}
