package com.uniminuto.primer_parcial.repositorios;

import com.uniminuto.primer_parcial.modelos.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Medico.
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}