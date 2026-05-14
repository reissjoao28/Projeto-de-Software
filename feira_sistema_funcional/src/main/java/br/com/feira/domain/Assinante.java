package br.com.feira.domain;

public class Assinante {

    private String nome;
    private String telefone;

    public Assinante(String nome,String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}