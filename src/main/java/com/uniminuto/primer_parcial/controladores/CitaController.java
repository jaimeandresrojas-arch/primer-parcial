package com.uniminuto.primer_parcial.controladores;

import com.uniminuto.primer_parcial.dtos.CitaDTO;
import com.uniminuto.primer_parcial.dtos.CitaRequestDTO;
import com.uniminuto.primer_parcial.modelos.Cita;
import com.uniminuto.primer_parcial.servicios.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping("/guardar")
    public ResponseEntity<Cita> crearCita(@RequestBody CitaRequestDTO citaDTO) {
        Cita nuevaCita = citaService.guardarCita(citaDTO);
        if (nuevaCita != null) {
            return ResponseEntity.ok(nuevaCita);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ordenadas-por-fecha")
    public List<CitaDTO> listarCitasOrdenadasPorFecha() {
        return citaService.listarCitasRecientesPrimero();
    }
}