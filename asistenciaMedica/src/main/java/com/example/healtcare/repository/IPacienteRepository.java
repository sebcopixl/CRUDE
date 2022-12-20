package com.example.healtcare.repository;


import com.example.healtcare.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de la entidad {@link Paciente}
 * <p>
 * Todas las operaciones de persistencia o acceso a la base de datos de un {@link Paciente} deben ser procesadas
 * por esta clase
 */
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
