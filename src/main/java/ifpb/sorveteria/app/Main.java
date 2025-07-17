package ifpb.sorveteria.app;

import ifpb.sorveteria.command.PedidoCommand;
import ifpb.sorveteria.decorator.AdicionalGotasChocolate;
import ifpb.sorveteria.decorator.CoberturaMorango;
import ifpb.sorveteria.decorator.CoberturaUva;
import ifpb.sorveteria.factory.*;
import ifpb.sorveteria.model.MilkShake;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.model.Picole;
import ifpb.sorveteria.model.Sorvete;
import ifpb.sorveteria.observer.ClienteObserver;
import ifpb.sorveteria.observer.Observer;
import ifpb.sorveteria.strategy.Desconto10;
import ifpb.sorveteria.strategy.DescontoStrategy;

public class Main {
    public static void main(String[] args) throws Exception {

        Pedido pedido = new Pedido();
        Item sorvete = new SorveteFactory().criarItem("Chocolate");

        pedido.adicionarPedido(sorvete);

        System.out.println(pedido.getValorFinal());

        DescontoStrategy descontoStrategy = new Desconto10();

        descontoStrategy.calcularDesconto(pedido);

        System.out.println("Desconto: " + descontoStrategy.calcularDesconto(pedido));
    }
}
