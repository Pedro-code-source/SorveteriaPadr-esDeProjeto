package ifpb.sorveteria.facade;

import ifpb.sorveteria.Interfaces.Item;
import ifpb.sorveteria.Interfaces.DescontoStrategy;
import ifpb.sorveteria.decorator.*;
import ifpb.sorveteria.factory.MilkShakeFactory;
import ifpb.sorveteria.factory.PedidoFactory;
import ifpb.sorveteria.factory.PicoleFactory;
import ifpb.sorveteria.factory.SorveteFactory;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.repository.PedidoRepository;
import ifpb.sorveteria.repository.Repository;
import ifpb.sorveteria.singleton.GerenciarPedidos;
import ifpb.sorveteria.strategy.Desconto;
import ifpb.sorveteria.strategy.Desconto10;
import ifpb.sorveteria.strategy.Desconto20;
import ifpb.sorveteria.strategy.Desconto30;

import java.sql.SQLException;
import java.util.Scanner;

public class SorveteriaFacade {
    Pedido pedido;
    GerenciarPedidos gerenciarPedidos;
    Item item;
    Scanner scTeste = new Scanner(System.in);
    Repository repositorio = new Repository();

    public void opcaoSorvete() {
        System.out.println("Escolha o sabor do sorvete:");
        System.out.println("1- Maracujá\n2- Chocolate\n3- Baunilha");
        int opcao = scTeste.nextInt();
        switch (opcao) {
            case 1 -> item = new SorveteFactory().criarItem("Maracujá");
            case 2 -> item = new SorveteFactory().criarItem("Chocolate");
            case 3 -> item = new SorveteFactory().criarItem("Baunilha");
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                opcaoSorvete();
            }
        }
    }

    public void opcaoMilkShake() {
        System.out.println("Escolha o sabor do Milk Shake:");
        System.out.println("1- Morango\n2- Chocolate\n3- Creme");
        int opcao = scTeste.nextInt();
        switch (opcao) {
            case 1 -> item = new MilkShakeFactory().criarItem("Morango");
            case 2 -> item = new MilkShakeFactory().criarItem("Chocolate");
            case 3 -> item = new MilkShakeFactory().criarItem("Creme");
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                opcaoMilkShake();
            }
        }
    }

    public void opcaoPicole() {
        System.out.println("Escolha o sabor do Picolé:");
        System.out.println("1- Uva\n2- Pedacinho do Céu\n3- Leite Condensado");
        int opcao = scTeste.nextInt();
        switch (opcao) {
            case 1 -> item = new PicoleFactory().criarItem("Uva");
            case 2 -> item = new PicoleFactory().criarItem("Pedacinho do Céu");
            case 3 -> item = new PicoleFactory().criarItem("Leite Condensado");
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                opcaoPicole();
            }
        }
    }

    public void adicionais() {
        System.out.println("Adicionais disponíveis:");
        System.out.println("1- Amendoim\n2- Gotas de Chocolate\n3- Granulado");
        int opcao = scTeste.nextInt();
        switch (opcao) {
            case 1 -> item = new AdicionalAmendoim(item);
            case 2 -> item = new AdicionalGotasChocolate(item);
            case 3 -> item = new AdicionalGranulado(item);
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                adicionais();
            }
        }
    }

    public void cobertura() {
        System.out.println("Coberturas disponíveis:");
        System.out.println("1- Chocolate\n2- Morango\n3- Uva");
        int opcao = scTeste.nextInt();

        switch (opcao) {
            case 1 -> item = new CoberturaChocolate(item);
            case 2 -> item = new CoberturaMorango(item);
            case 3 -> item = new CoberturaUva(item);
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                cobertura();
            }
        }
    }

    public void escolherExtra() {
        System.out.println("Deseja colocar algum extra?");
        System.out.println("1- Adicional\n2- Cobertura\n3- Não");
        int escolha = scTeste.nextInt();

        switch (escolha) {
            case 1 -> adicionais();
            case 2 -> cobertura();
            case 3 -> {}
            default -> {
                System.out.println("Opção Invalida!");
                System.out.println("Escolha novamente!");
                escolherExtra();
            }
        }
    }

    public void aplicarDesconto() {
        Desconto desconto = new Desconto();
        desconto.setDesconto(0);
        DescontoStrategy estrategia;
        System.out.println("Digite seu cupom de desconto:");
        String escolha = scTeste.nextLine();
        switch (escolha) {
            case "CUPOM10":
                estrategia = new Desconto10();
                estrategia.aplicarDesconto(pedido.getValorFinal());
                desconto.setDesconto(10);
                pedido.setValorFinal(desconto.getDesconto());
                System.out.println("Desconto de 10% aplicado!");
                break;
            case "CUPOM20":
                estrategia = new Desconto20();
                estrategia.aplicarDesconto(pedido.getValorFinal());
                desconto.setDesconto(20);
                pedido.setValorFinal(desconto.getDesconto());
                System.out.println("Desconto de 20% aplicado!");
                break;
            case "CUPOM30":
                estrategia = new Desconto30();
                estrategia.aplicarDesconto(pedido.getValorFinal());
                desconto.setDesconto(30);
                pedido.setValorFinal(desconto.getDesconto());
                System.out.println("Desconto de 30% aplicado!");
                break;
            default:
            {
                System.out.println("Cupom inválido, aplicando desconto padrão (0%).");
                estrategia = valorOriginal -> valorOriginal;
            }
        }

        double valorComDesconto = estrategia.aplicarDesconto(pedido.calcularValorFinal());
        pedido.setValorFinal(valorComDesconto);
        System.out.printf("💰 Valor com desconto: R$%.2f%n", valorComDesconto);
    }

    public void confirmacaoPedido() throws SQLException {
        System.out.println("Deseja confirmar o pedido?");
        pedido.exibirItens();
        System.out.println("1 - Confirmar\n2 - Cancelar");
        int opcaoConfirma = scTeste.nextInt();
        scTeste.nextLine();

        switch (opcaoConfirma) {
            case 1 -> {
                aplicarDesconto();
                pedido.setIdPedido(pedido.getIdPedido()+1);
//                boolean pedidoExistente = gerenciarPedidos.getPedidos().stream()
//                        .anyMatch(p -> p.getIdPedido() == pedido.getIdPedido());
//                if (pedidoExistente) {
//                    System.out.println("⚠️ Erro: já existe um pedido com ID " + pedido.getIdPedido());
//                } else {
                    gerenciarPedidos.adicionarPedido(pedido);
                    gerenciarPedidos.listarPedidos();
                    repositorio.salvarPedido(pedido);
                    System.out.println("✅ Pedido confirmado e salvo!");

//                }
            }
            case 2 -> {
                pedido.removerItem(item);
                System.out.println("❌ Pedido cancelado.");
            }
            default -> System.out.println("Opção Inválida!");
        }
    }

    public void iniciar() throws Exception {
        System.out.println("=".repeat(23));
        System.out.println("BEM VINDO À SORVETERIA!");
        System.out.println("=".repeat(23));

        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        while (opcao != 2) {
            System.out.println("O que você deseja?");
            System.out.println("1- Fazer pedido\n2- Sair");
            opcao = sc.nextInt();

            if (opcao == 1) {
                gerenciarPedidos = GerenciarPedidos.getInstance();
                pedido = new PedidoFactory().criarPedido();

                System.out.println("Escolha seu pedido:");
                System.out.println("1- Sorvete\n2- Milkshake\n3- Picolé");
                int massa = sc.nextInt();

                switch (massa) {
                    case 1 -> {
                        opcaoSorvete();
                        escolherExtra();
                        pedido.adicionarItem(item);
                    }
                    case 2 -> {
                        opcaoMilkShake();
                        escolherExtra();
                        pedido.adicionarItem(item);
                    }
                    case 3 -> {
                        opcaoPicole();
                        pedido.adicionarItem(item);
                    }
                    default -> System.out.println("Opção Inválida!");
                }


                confirmacaoPedido();

            }
            else if (opcao == 2) {
                System.out.println("👋 Até a próxima!");
                gerenciarPedidos.listarPedidos();
                break;
            }
        }
    }
}

