package com.uniminuto.primer_parcial.servicios;

import com.uniminuto.primer_parcial.modelos.Paciente;
import com.uniminuto.primer_parcial.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de pacientes.
 */
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Guarda un nuevo paciente en la base de datos.
     * @param paciente el objeto Paciente a guardar.
     * @return el objeto Paciente guardado.
     */
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Lista todos los pacientes ordenados por fecha de nacimiento de forma descendente.
     * @return una lista de pacientes ordenados del mayor al menor por fecha de nacimiento.
     */
    public List<Paciente> listarPacientesOrdenadosPorFechaNacimiento() {
        return pacienteRepository.findAllByOrderByFechaNacimientoDesc();
    }
}