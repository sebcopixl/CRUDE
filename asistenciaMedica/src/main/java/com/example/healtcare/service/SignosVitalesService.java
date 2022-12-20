package com.example.healtcare.service;

import com.example.healtcare.domain.Paciente;
import com.example.healtcare.domain.SignosVitales;
import com.example.healtcare.repository.ISignosVitalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación de la interfaz {@link ISignosVitalesService}
 * <p>
 * Todas las operaciones relacionadas a la lógica de negocio de un {@link Paciente} deben ser procesadas por esta clase
 */
@Service
public class SignosVitalesService implements ISignosVitalesService {
    private final Logger logger = LoggerFactory.getLogger(SignosVitalesService.class);

    private final ISignosVitalesRepository repository;

    @Autowired
    public SignosVitalesService(ISignosVitalesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(SignosVitales signosVitales) {
        logger.debug("Guardar signos vitales [signosVitales: {}]", signosVitales);
        repository.save(signosVitales);
    }

    @Override
    public void eliminar(Long id) {
        logger.debug("Eliminar signos vitales [id: {}]", id);
        repository.deleteById(id);
    }
    /*
    * Obtiene el signo vital a traves del ID*/

    @Override
    public SignosVitales getSignoVitalById(Long id) {
        logger.debug("getSignoVitalById [id: {}]", id);
        return repository.getReferenceById(id);
    }
}
