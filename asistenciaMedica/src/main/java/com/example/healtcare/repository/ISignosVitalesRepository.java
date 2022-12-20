package com.example.healtcare.repository;

import com.example.healtcare.domain.SignosVitales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de la entidad {@link SignosVitales}
 * <p>
 * Todas las operaciones de persistencia o acceso a la base de datos de un {@link SignosVitales} deben ser procesadas
 * por esta clase
 */
@Repository
public interface ISignosVitalesRepository extends JpaRepository<SignosVitales, Long> {

}
