package com.example.healtcare.service;

import com.example.healtcare.domain.Paciente;
import com.example.healtcare.domain.SignosVitales;

/**
 * Interfaz del service de la entidad {@link Paciente}
 * <p>
 * Todas las operaciones relacionadas a la lógica de negocio de los {@link SignosVitales} deben ser procesadas por esta clase
 */
public interface ISignosVitalesService {

    /**
     * Guarda los signos vitales de un paciente
     *
     * @param signosVitales objeto signos vitales para guardar
     */
    void guardar(SignosVitales signosVitales);

    /**
     * Elimina los signos vitales de un paciente
     *
     * @param id identificador del signo vital
     */
    void eliminar(Long id);

    /**
     * Edita los signos vitales de un paciente
     *
     * @param id identificador del signo vital
     */
    SignosVitales getSignoVitalById(Long id);
}
