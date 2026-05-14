package br.com.feira.domain;

public abstract class Produto {

    protected String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}