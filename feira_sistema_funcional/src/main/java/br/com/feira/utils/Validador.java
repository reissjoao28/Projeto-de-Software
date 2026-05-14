package br.com.feira.utils;

public class Validador {

    public static boolean validarNome(String texto) {
        return texto.matches("^[A-Za-zÀ-ÿ ]+$");
    }

    public static boolean validarTelefone(String texto) {
        return texto.matches("^\\d{10,11}$");
    }

    public static boolean validarRua(String texto) {
        return texto.matches("^[A-Za-zÀ-ÿ ]+$");
    }

    public static boolean validarBairro(String texto) {
        return texto.matches("^[A-Za-zÀ-ÿ ]+$");
    }

    public static boolean validarNumeroCasa(String texto) {
        return texto.matches("^\\d+$");
    }

    public static boolean validarCEP(String texto) {
        return texto.matches("^\\d{8}$");
    }

    public static boolean validarCartao(String texto) {
        return texto.matches("^\\d{16}$");
    }

    public static boolean validarValidade(String texto) {
        return texto.matches("^(0[1-9]|1[0-2])/[0-9]{2}$");
    }
}