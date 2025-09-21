package com.uniminuto.primer_parcial.controladores;

import com.uniminuto.primer_parcial.modelos.Receta;
import com.uniminuto.primer_parcial.servicios.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @PostMapping("/cita/{citaId}")
    public ResponseEntity<Receta> crearReceta(
            @RequestBody Receta receta,
            @PathVariable Long citaId) {

        Receta nuevaReceta = recetaService.guardarReceta(receta, citaId);
        if (nuevaReceta != null) {
            return ResponseEntity.ok(nuevaReceta);
        }
        return ResponseEntity.badRequest().build();
    }
}