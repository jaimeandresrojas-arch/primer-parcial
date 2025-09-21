package com.uniminuto.primer_parcial.repositorios;

import com.uniminuto.primer_parcial.modelos.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}