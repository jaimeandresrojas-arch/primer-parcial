package com.uniminuto.primer_parcial.controladores;

import com.uniminuto.primer_parcial.modelos.Medico;
import com.uniminuto.primer_parcial.servicios.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> guardarMedico(@RequestBody Medico medico) {
        Medico nuevoMedico = medicoService.guardarMedico(medico);
        return new ResponseEntity<>(nuevoMedico, HttpStatus.CREATED);
    }
}