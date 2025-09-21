package com.uniminuto.primer_parcial.controladores;

import com.uniminuto.primer_parcial.modelos.Paciente;
import com.uniminuto.primer_parcial.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de pacientes.
 */
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /**
     * Endpoint para guardar un nuevo paciente.
     * @param paciente el objeto Paciente a guardar.
     * @return un ResponseEntity con el objeto Paciente guardado y el estado HTTP 201.
     */
    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.guardarPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar pacientes ordenados por fecha de nacimiento (mayor a menor).
     * @return Una lista de pacientes.
     */
    @GetMapping("/ordenados-por-nacimiento")
    public List<Paciente> getPacientesOrdenadosPorNacimiento() {
        return pacienteService.listarPacientesOrdenadosPorFechaNacimiento();
    }
}