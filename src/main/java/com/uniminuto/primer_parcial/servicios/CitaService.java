package com.uniminuto.primer_parcial.servicios;

import com.uniminuto.primer_parcial.dtos.CitaDTO;
import com.uniminuto.primer_parcial.dtos.CitaRequestDTO;
import com.uniminuto.primer_parcial.modelos.Cita;
import com.uniminuto.primer_parcial.modelos.Medico;
import com.uniminuto.primer_parcial.modelos.Paciente;
import com.uniminuto.primer_parcial.repositorios.CitaRepository;
import com.uniminuto.primer_parcial.repositorios.MedicoRepository;
import com.uniminuto.primer_parcial.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public Cita guardarCita(CitaRequestDTO citaDTO) {
        Optional<Paciente> paciente = pacienteRepository.findById(citaDTO.getPacienteId());
        Optional<Medico> medico = medicoRepository.findById(citaDTO.getMedicoId());

        if (paciente.isPresent() && medico.isPresent()) {
            Cita cita = new Cita();
            cita.setPaciente(paciente.get());
            cita.setMedico(medico.get());
            cita.setFechaHora(LocalDateTime.parse(citaDTO.getFechaHora())); // Conversión de la cadena a LocalDateTime
            cita.setEstado(citaDTO.getEstado());
            cita.setMotivo(citaDTO.getMotivo());
            return citaRepository.save(cita);
        } else {
            return null;
        }
    }

    public List<CitaDTO> listarCitasRecientesPrimero() {
        return citaRepository.findAllByOrderByFechaHoraDesc()
                .stream()
                .map(cita -> {
                    CitaDTO dto = new CitaDTO();
                    dto.setId(cita.getId());
                    dto.setFechaHora(cita.getFechaHora());
                    dto.setEstado(cita.getEstado());
                    dto.setMotivo(cita.getMotivo());
                    dto.setPacienteId(cita.getPaciente().getId());
                    dto.setMedicoId(cita.getMedico().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}