package com.nath.agendador.domain;

import java.time.LocalDateTime;

import com.nath.agendador.domain.enums.StatusAgendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private StatusAgendamento status;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String observacoes;

    public Agenda(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String observacoes) {
        this.status = StatusAgendamento.AGENDADO;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacoes = observacoes;
    }

    public Agenda(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.status = StatusAgendamento.AGENDADO;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

}
