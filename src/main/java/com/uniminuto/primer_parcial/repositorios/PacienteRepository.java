package com.uniminuto.primer_parcial.repositorios;

import com.uniminuto.primer_parcial.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Paciente.
 * Proporciona métodos para operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    /**
     * Busca todos los pacientes y los ordena por fecha de nacimiento de forma descendente.
     * @return una lista de pacientes ordenados del mayor al menor por fecha de nacimiento.
     */
    List<Paciente> findAllByOrderByFechaNacimientoDesc();
}