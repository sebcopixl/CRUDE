package com.example.healtcare.service;

import com.example.healtcare.domain.SignosVitales;
import com.example.healtcare.repository.ISignosVitalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void actualizar(Long id, SignosVitales nuevosSignosVitales) {
        logger.debug("Actualizar signos vitales [id: {}]", id);
        SignosVitales signosVitales = repository.getReferenceById(id);

        // Perform the necessary updates to the SignosVitales object
        signosVitales.setFechaRegistro(nuevosSignosVitales.getFechaRegistro());
        signosVitales.setPresion(nuevosSignosVitales.getPresion());
        signosVitales.setFrecuencia(nuevosSignosVitales.getFrecuencia());

        repository.save(signosVitales);
    }

    @Override
    public SignosVitales getSignoVitalById(Long id) {
        logger.debug("getSignoVitalById [id: {}]", id);
        return repository.getReferenceById(id);
    }
}
