package com.nath.agendador.domain.enums;

public enum StatusAgendamento {
    AGENDADO("Agendado - Pode realizar agendamentos"),
    ANDAMENTO("Andamento - Atendimento sendo realizado no momento"),
    CANCELADO("Cancelado - Realizou o cancelamento do agendamento");

    private final String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
