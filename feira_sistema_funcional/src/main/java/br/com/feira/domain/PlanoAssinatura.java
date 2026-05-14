package br.com.feira.domain;

public class PlanoAssinatura {

    private String nome;
    private double preco;
    private int limiteItens;

    public PlanoAssinatura(String nome,double preco,int limiteItens) {
        this.nome = nome;
        this.preco = preco;
        this.limiteItens = limiteItens;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getLimiteItens() {
        return limiteItens;
    }
}