package ifpb.sorveteria.app;

import ifpb.sorveteria.decorator.AdicionalGotasChocolate;
import ifpb.sorveteria.decorator.CoberturaMorango;
import ifpb.sorveteria.decorator.CoberturaUva;
import ifpb.sorveteria.factory.*;
import ifpb.sorveteria.model.MilkShake;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.model.Picole;
import ifpb.sorveteria.model.Sorvete;

public class Main {
    public static void main(String[] args) throws Exception {
    Item sorvete = new SorveteFactory().criarItem("Maracujá");
    Item milkshake = new MilkShakeFactory().criarItem("Abacaxi");

    sorvete = new CoberturaUva(sorvete);
    milkshake = new AdicionalGotasChocolate(milkshake);
    sorvete = new AdicionalGotasChocolate(sorvete);
    Pedido pedido = new PedidoFactory().criarPedido();
    pedido.adicionarPedido(sorvete);
    pedido.adicionarPedido(milkshake);
    pedido.listarPedidos();
        System.out.println(pedido.getPedidos());

    }
}
