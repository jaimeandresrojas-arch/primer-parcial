package com.uniminuto.primer_parcial.servicios;

import com.uniminuto.primer_parcial.modelos.Medico;
import com.uniminuto.primer_parcial.repositorios.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }
}