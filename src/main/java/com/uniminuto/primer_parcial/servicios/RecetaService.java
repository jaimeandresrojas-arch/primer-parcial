package com.uniminuto.primer_parcial.servicios;

import com.uniminuto.primer_parcial.modelos.Cita;
import com.uniminuto.primer_parcial.modelos.Receta;
import com.uniminuto.primer_parcial.repositorios.CitaRepository;
import com.uniminuto.primer_parcial.repositorios.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private CitaRepository citaRepository;

    public Receta guardarReceta(Receta receta, Long citaId) {
        Cita cita = citaRepository.findById(citaId).orElse(null);
        if (cita != null) {
            receta.setCita(cita);
            return recetaRepository.save(receta);
        }
        return null;
    }
}