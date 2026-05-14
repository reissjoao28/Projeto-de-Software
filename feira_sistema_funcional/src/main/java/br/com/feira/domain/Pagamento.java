package br.com.feira.domain;

public class Pagamento {

    private String numeroCartao;
    private String titular;
    private String validade;
    private String status;

    public Pagamento(String numeroCartao,String titular,String validade) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
        this.validade = validade;
        status = "PENDENTE";
    }

    public boolean processarPagamento() {

        OperadoraCartao operadora = new OperadoraCartao();

        boolean aprovado = operadora.autorizarPagamento(numeroCartao);

        if(aprovado) {
            status = "APROVADO";
            return true;
        }

        status = "RECUSADO";
        return false;
    }

    @Override
    public String toString() {
        return "\n===== PAGAMENTO =====\nStatus: " + status;
    }
}