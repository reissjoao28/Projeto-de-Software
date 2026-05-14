package br.com.feira.repository;

import br.com.feira.domain.Assinante;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoRepository {

    private static final String CAMINHO = "assinantes.csv";

    public void salvarAssinante(Assinante assinante) {

        try {

            File arquivo = new File(CAMINHO);

            boolean novo = !arquivo.exists();

            FileWriter writer = new FileWriter(arquivo,true);

            if(novo) {
                writer.write("NOME;TELEFONE\n");
            }

            writer.write(
                    assinante.getNome()
                    + ";"
                    + assinante.getTelefone()
                    + "\n"
            );

            writer.close();

        } catch(IOException e) {
            System.out.println("Erro ao salvar CSV.");
        }
    }
}