package br.com.feira.domain;

public class OperadoraCartao {

    public boolean autorizarPagamento(String numeroCartao) {
        return numeroCartao.length() == 16;
    }
}