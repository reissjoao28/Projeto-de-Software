package br.com.feira.domain;

public class AutenticacaoSMS {

    private String codigo;

    public AutenticacaoSMS(String codigo) {
        this.codigo = codigo;
    }

    public boolean validar(String codigo) {
        return this.codigo.equals(codigo);
    }
}