package com.uniminuto.primer_parcial.dtos;

import java.time.LocalDateTime;

public class CitaRequestDTO {
    private Long pacienteId;
    private Long medicoId;
    private String fechaHora; // Aquí la fecha es una cadena
    private String estado;
    private String motivo;

    // Getters y Setters
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}