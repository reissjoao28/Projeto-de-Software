package br.com.feira.domain;

import java.util.ArrayList;
import java.util.List;

public class CestaSemanal {

    private List<ItemCesta> itens = new ArrayList<>();

    public void adicionarItem(ItemCesta item) {
        itens.add(item);
    }

    public void resumo(PlanoAssinatura plano) {

        int total = 0;

        System.out.println("\n===== RESUMO DA CESTA =====");

        for(ItemCesta item : itens) {

            System.out.println(
                    item.getProduto().getNome()
                    + " x"
                    + item.getQuantidade()
            );

            total += item.getQuantidade();
        }

        System.out.println("TOTAL DE ITENS: " + total);
        System.out.println("PLANO: " + plano.getNome());
    }
}