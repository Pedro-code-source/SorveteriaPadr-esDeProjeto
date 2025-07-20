package ifpb.sorveteria.app;

import ifpb.sorveteria.decorator.AdicionalGotasChocolate;
import ifpb.sorveteria.decorator.CoberturaMorango;
import ifpb.sorveteria.factory.*;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.singleton.GerenciarPedidos;
import ifpb.sorveteria.strategy.Desconto10;
import ifpb.sorveteria.strategy.DescontoStrategy;

public class Main {
    public static void main(String[] args) throws Exception {

        Pedido pedido = new PedidoFactory().criarPedido();
        Pedido pedido2 =  new PedidoFactory().criarPedido();
        Item sorvete = new SorveteFactory().criarItem("Chocolate");
        Item milkshake = new MilkShakeFactory().criarItem("Maracujá");
        sorvete = new AdicionalGotasChocolate(new CoberturaMorango(sorvete));
        milkshake = new AdicionalGotasChocolate(milkshake);
        pedido.adicionarItem(sorvete);
        pedido.adicionarItem(milkshake);
        pedido2.adicionarItem(milkshake);

        GerenciarPedidos gerenciarPedidos = GerenciarPedidos.getInstance();
        gerenciarPedidos.adicionarPedido(pedido);
        gerenciarPedidos.adicionarPedido(pedido2);
        gerenciarPedidos.listarPedidos();
//        pedido.listarPedidos();
        DescontoStrategy descontoStrategy = new Desconto10();

        descontoStrategy.calcularDesconto(pedido);
        pedido.calcularValorFinal();
        System.out.println(pedido.getValorFinal());
        System.out.println("Valor final com desconto: " + descontoStrategy.calcularDesconto(pedido) + "R$");
    }
}
