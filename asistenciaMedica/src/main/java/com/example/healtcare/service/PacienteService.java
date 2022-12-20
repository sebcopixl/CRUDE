package com.example.healtcare.service;

import com.example.healtcare.domain.Paciente;
import com.example.healtcare.repository.IPacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz {@link IPacienteService}
 * <p>
 * Todas las operaciones relacionadas a la lógica de negocio de un {@link Paciente} deben ser procesadas por esta clase
 */
@Service
public class PacienteService implements IPacienteService {
    private final Logger logger = LoggerFactory.getLogger(PacienteService.class);

    private final IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listarPaciente() {
        logger.debug("listAll");
        return pacienteRepository.findAll();
    }

    @Override
    public void guardar(Paciente paciente) {
        logger.debug("Guardar [paciente: {}] ", paciente);
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long codigo) {
        logger.debug("Eliminar paciente [codigo: {}]", codigo);
        pacienteRepository.deleteById(codigo);
    }

    @Override
    public Paciente getPacienteByCodigo(Long codigo) {
        logger.debug("getPacienteByCodigo [codigo: {}]", codigo);
        return pacienteRepository.getReferenceById(codigo);
    }
}
