package br.com.feira.domain;

public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public Endereco(String rua,String numero,String bairro,String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + bairro + " CEP: " + cep;
    }
}