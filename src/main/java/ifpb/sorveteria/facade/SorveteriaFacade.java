package ifpb.sorveteria.facade;

import ifpb.sorveteria.Interfaces.Item;
import ifpb.sorveteria.decorator.*;
import ifpb.sorveteria.factory.MilkShakeFactory;
import ifpb.sorveteria.factory.PedidoFactory;
import ifpb.sorveteria.factory.PicoleFactory;
import ifpb.sorveteria.factory.SorveteFactory;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.singleton.GerenciarPedidos;

import java.util.Scanner;

public class SorveteriaFacade {
    Pedido pedido;
    GerenciarPedidos gerenciarPedidos;
    Item item;

Scanner scTeste = new Scanner(System.in);

public void opcaoSorvete() {
    System.out.println("Escolha o sabor do sorvete:");
    System.out.println("1- Maracujá\n2- Chocolate\n3- Baunilha");
    int opcao = scTeste.nextInt();
    switch (opcao) {
        case 1: {
            item = new SorveteFactory().criarItem("Maracujá");
            break;
        }
        case 2: {
            item = new SorveteFactory().criarItem("Chocolate");
            break;
        }
        case 3: {
            item = new SorveteFactory().criarItem("Baunilha");
            break;
        }
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            opcaoSorvete();
    }
}

public void opcaoMilkShake() {
    System.out.println("Escolha o sabor do Milk Shake:");
    System.out.println("1- Morango\n2- Chocolate\n3- Creme");
    int opcao = scTeste.nextInt();
    switch (opcao) {
        case 1: {
            item = new MilkShakeFactory().criarItem("Morango");
            break;
        }
        case 2: {
            item = new MilkShakeFactory().criarItem("Chocolate");
            break;
        }
        case 3: {
            item = new MilkShakeFactory().criarItem("Creme");
            break;
        }
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            opcaoMilkShake();
    }
}

public  void opcaoPicole() {
    System.out.println("Escolha o sabor do Picolé:");
    System.out.println("1- Uva\n2- Pedacinho do Céu\n3- Leite Condensado");
    int opcao = scTeste.nextInt();
    switch (opcao) {
        case 1: {
            item = new PicoleFactory().criarItem("Uva");
            break;
        }
        case 2: {
            item = new PicoleFactory().criarItem("Pedacinho do Céu");
            break;
        }
        case 3: {
            item = new PicoleFactory().criarItem("Leite Condensado");
            break;
        }
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            opcaoPicole();
    }
}

public void adicionais() {
    System.out.println("Adicionais disponíveis:");
    System.out.println("1- Amendoim\n2- Gotas de Chocolate\n3- Granulado");
    int opcao = scTeste.nextInt();
    switch (opcao) {
        case 1:
            item = new AdicionalAmendoim(item);
            break;
        case 2:
            item = new AdicionalGotasChocolate(item);
            break;
        case 3:
            item = new AdicionalGranulado(item);
            break;
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            adicionais();
    }
}

public void cobertura(){
    System.out.println("Coberturas disponíveis:");
    System.out.println("1- Chocolate\n2- Morango\n3- Uva");
    int opcao = scTeste.nextInt();

    switch (opcao) {
        case 1:
            item = new CoberturaChocolate(item);
            break;
        case 2:
            item = new CoberturaMorango(item);
            break;
        case 3:
            item = new CoberturaUva(item);
            break;
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            cobertura();
    }
}

public void escolherExtra() {
    System.out.println("Deseja colocar algum extra?");
    System.out.println("1- Adicional\n2- Cobertura\n3- Não");
    int escolha = scTeste.nextInt();

    switch (escolha) {
        case 1:
            adicionais();
            break;
        case 2:
            cobertura();
            break;
        case 3:
            break;
        default:
            System.out.println("Opção Invalida!");
            System.out.println("Escolha novamente!");
            escolherExtra();
    }
}

public void confirmacaoPedido() {
    System.out.println("Deseja confirmar o pedido?");
    pedido.listarItens();
    System.out.println("1 - Confirmar\n2 - Cancelar");
    int opcaoConfirma = scTeste.nextInt();
    switch (opcaoConfirma) {
        case 1:
            gerenciarPedidos.adicionarPedido(pedido);
            gerenciarPedidos.listarPedidos();
            break;
        case 2:
            pedido.removerItem(item);
            break;
        default:
            System.out.println("Opção Inválida!");
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
                case 1:
                    opcaoSorvete();
                    escolherExtra();
                    pedido.adicionarItem(item);
                    break;
                case 2:
                    opcaoMilkShake();
                    escolherExtra();
                    pedido.adicionarItem(item);
                    break;
                case 3:
                    opcaoPicole();
                    pedido.adicionarItem(item);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
        else if (opcao == 2) {
            break;
        }
        confirmacaoPedido();
        }
    }
}