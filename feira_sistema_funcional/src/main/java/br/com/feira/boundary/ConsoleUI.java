package br.com.feira.boundary;

import br.com.feira.controller.AssinaturaController;
import br.com.feira.domain.*;
import br.com.feira.repository.ArquivoRepository;
import br.com.feira.utils.Validador;

import java.util.Scanner;

public class ConsoleUI {

    public void iniciar() {

        Scanner scanner = new Scanner(System.in);
        AssinaturaController controller = new AssinaturaController();
        ArquivoRepository repository = new ArquivoRepository();

        String nome;

        do {
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if(!Validador.validarNome(nome)) {
                System.out.println("Nome inválido.");
            }

        } while(!Validador.validarNome(nome));

        String telefone;

        do {
            System.out.print("Telefone: ");
            telefone = scanner.nextLine();

            if(!Validador.validarTelefone(telefone)) {
                System.out.println("Telefone inválido.");
            }

        } while(!Validador.validarTelefone(telefone));

        Assinante assinante = new Assinante(nome, telefone);

        repository.salvarAssinante(assinante);

        AutenticacaoSMS sms = new AutenticacaoSMS("1234");

        System.out.println("\nCódigo SMS enviado: 1234");
        System.out.print("Digite o código: ");

        String codigo = scanner.nextLine();

        if(!sms.validar(codigo)) {
            System.out.println("Código inválido.");
            return;
        }

        System.out.println("\n===== PLANOS =====");
        System.out.println("1 - Básico (18 itens)");
        System.out.println("2 - Premium (30 itens)");

        int opcaoPlano = scanner.nextInt();
        scanner.nextLine();

        PlanoAssinatura plano;

        if(opcaoPlano == 1) {
            plano = new PlanoAssinatura("Básico",59.90,18);
        } else {
            plano = new PlanoAssinatura("Premium",99.90,30);
        }

        Assinatura assinatura = new Assinatura();
        assinatura.adicionarPlano(plano);

        CestaSemanal cesta = new CestaSemanal();

        int total = 0;

        while(total < plano.getLimiteItens()) {

            System.out.println("\n===== FRUTAS =====");
            System.out.println("1 - Banana");
            System.out.println("2 - Maçã");
            System.out.println("3 - Laranja");
            System.out.println("4 - Pular");

            int fruta = scanner.nextInt();

            if(fruta != 4) {

                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();

                if(total + qtd > plano.getLimiteItens()) {
                    System.out.println("Limite excedido.");
                    continue;
                }

                Produto produto;

                if(fruta == 1)
                    produto = controller.criarFruta("Banana");
                else if(fruta == 2)
                    produto = controller.criarFruta("Maçã");
                else
                    produto = controller.criarFruta("Laranja");

                cesta.adicionarItem(new ItemCesta(produto, qtd));

                total += qtd;
            }

            if(total == plano.getLimiteItens()) {
                break;
            }

            System.out.println("\n===== LEGUMES =====");
            System.out.println("1 - Cenoura");
            System.out.println("2 - Batata");
            System.out.println("3 - Beterraba");
            System.out.println("4 - Pular");

            int legume = scanner.nextInt();

            if(legume != 4) {

                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();

                if(total + qtd > plano.getLimiteItens()) {
                    System.out.println("Limite excedido.");
                    continue;
                }

                Produto produto;

                if(legume == 1)
                    produto = controller.criarLegume("Cenoura");
                else if(legume == 2)
                    produto = controller.criarLegume("Batata");
                else
                    produto = controller.criarLegume("Beterraba");

                cesta.adicionarItem(new ItemCesta(produto, qtd));

                total += qtd;
            }

            if(total == plano.getLimiteItens()) {
                break;
            }

            System.out.println("\n===== VERDURAS =====");
            System.out.println("1 - Alface");
            System.out.println("2 - Couve");
            System.out.println("3 - Rúcula");
            System.out.println("4 - Pular");

            int verdura = scanner.nextInt();

            if(verdura != 4) {

                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();

                if(total + qtd > plano.getLimiteItens()) {
                    System.out.println("Limite excedido.");
                    continue;
                }

                Produto produto;

                if(verdura == 1)
                    produto = controller.criarVerdura("Alface");
                else if(verdura == 2)
                    produto = controller.criarVerdura("Couve");
                else
                    produto = controller.criarVerdura("Rúcula");

                cesta.adicionarItem(new ItemCesta(produto, qtd));

                total += qtd;
            }
        }

        scanner.nextLine();

        String rua;

        do {
            System.out.print("Rua: ");
            rua = scanner.nextLine();
        } while(!Validador.validarRua(rua));

        String numero;

        do {
            System.out.print("Número: ");
            numero = scanner.nextLine();
        } while(!Validador.validarNumeroCasa(numero));

        String bairro;

        do {
            System.out.print("Bairro: ");
            bairro = scanner.nextLine();
        } while(!Validador.validarBairro(bairro));

        String cep;

        do {
            System.out.print("CEP: ");
            cep = scanner.nextLine();
        } while(!Validador.validarCEP(cep));

        Endereco endereco = new Endereco(rua,numero,bairro,cep);

        System.out.println("\nVALOR TOTAL: R$ " + plano.getPreco());

        String cartao;

        do {
            System.out.print("Cartão: ");
            cartao = scanner.nextLine();
        } while(!Validador.validarCartao(cartao));

        String titular;

        do {
            System.out.print("Titular: ");
            titular = scanner.nextLine();
        } while(!Validador.validarNome(titular));

        String validade;

        do {
            System.out.print("Validade MM/AA: ");
            validade = scanner.nextLine();
        } while(!Validador.validarValidade(validade));

        Pagamento pagamento = new Pagamento(cartao,titular,validade);

        if(!pagamento.processarPagamento()) {
            System.out.println("Pagamento recusado.");
            return;
        }

        assinatura.aprovar();

        System.out.println(pagamento);

        cesta.resumo(plano);

        System.out.println("\n===== ENTREGA =====");
        System.out.println(endereco);

        System.out.println("\nASSINATURA APROVADA");
        System.out.println("PROTOCOLO: " + assinatura.getNumeroProtocolo());
    }
}