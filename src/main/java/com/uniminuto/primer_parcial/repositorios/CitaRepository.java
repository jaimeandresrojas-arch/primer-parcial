package com.uniminuto.primer_parcial.repositorios;

import com.uniminuto.primer_parcial.modelos.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findAllByOrderByFechaHoraDesc();
}