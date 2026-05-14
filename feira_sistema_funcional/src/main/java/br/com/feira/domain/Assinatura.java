package br.com.feira.domain;

import java.util.UUID;

public class Assinatura {

    private String numeroProtocolo;
    private String status;
    private PlanoAssinatura plano;

    public Assinatura() {
        status = "PENDENTE";
        numeroProtocolo = UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public void adicionarPlano(PlanoAssinatura plano) {
        this.plano = plano;
    }

    public void aprovar() {
        status = "APROVADA";
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }
}