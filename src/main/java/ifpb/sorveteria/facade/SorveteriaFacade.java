package ifpb.sorveteria.facade;

import ifpb.sorveteria.Interfaces.Item;
import ifpb.sorveteria.decorator.*;
import ifpb.sorveteria.factory.PedidoFactory;
import ifpb.sorveteria.factory.SorveteFactory;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.model.Sorvete;
import ifpb.sorveteria.singleton.GerenciarPedidos;

import java.util.Scanner;

public class SorveteriaFacade {
    Pedido pedido;
    GerenciarPedidos gerenciarPedidos;
    Item item;

    public SorveteriaFacade() {
    }

    public void iniciar() throws Exception {


        System.out.println("=".repeat(23));
        System.out.println("BEM VINDO À SORVETERIA!");
        System.out.println("=".repeat(23));

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        while (opcao != 2){
            System.out.println("O que você deseja?");
            System.out.println("1- Fazer pedido\n2- Sair");
            opcao = sc.nextInt();

            if (opcao == 1) {
                gerenciarPedidos = GerenciarPedidos.getInstance();
                pedido = new PedidoFactory().criarPedido();


                System.out.println("Escolha seu pedido:");
                System.out.println("1- Sorvete\n2- Milkshake\n3- Picolé");
                int massa = sc.nextInt();

                switch (massa){
                    case 1:
                        System.out.println("Escolha o sabor do sorvete:");
                        System.out.println("1- Maracujá\n2- Chocolate\n3- Baunilha");
                        int opcaoSorvete = sc.nextInt();
                        switch (opcaoSorvete){
                            case 1:{
                                item = new SorveteFactory().criarItem("Maracujá");
                            break;
                            }
                            case 2:{
                                item = new SorveteFactory().criarItem("Chocolate");
                            break;
                            }
                            case 3:{
                                item = new SorveteFactory().criarItem("Baunilha");
                            break;
                            }
                        }

                        System.out.println("Deseja colocar algum extra?");

                        System.out.println("1- Adicional\n2- Cobertura\n3- Não");
                        int extra = sc.nextInt();
                        if (extra == 1){
                            System.out.println("Adicionais disponíveis:");
                            System.out.println("1- Amendoim\n2- Gotas de Chocolate\n3- Granulado");
                            int adicional = sc.nextInt();
                            switch (adicional){
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
                                    throw new Exception("Opção inválida!");
                            }
                        }
                        else if(extra == 2){
                            System.out.println("Coberturas disponíveis:");
                            System.out.println("1- Chocolate\n2- Morango\n3- Uva");
                            int cobertura = sc.nextInt();

                            switch (cobertura){
                                case 1:
                                    item = new CoberturaChocolate(item);
                                    break;
                                case 2:
                                    item = new CoberturaMorango(item);
                                    break;
                                case 3:
                                    item = new CoberturaUva(item);
                                    break;
                            }
                    }




                }
            }

        }
    }
}