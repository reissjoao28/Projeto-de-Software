package br.com.feira.controller;

import br.com.feira.domain.*;

public class AssinaturaController {

    public Produto criarFruta(String nome) {
        return new Fruta(nome);
    }

    public Produto criarLegume(String nome) {
        return new Legume(nome);
    }

    public Produto criarVerdura(String nome) {
        return new Verdura(nome);
    }
}