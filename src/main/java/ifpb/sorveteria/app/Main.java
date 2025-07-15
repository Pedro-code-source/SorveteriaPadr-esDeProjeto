package ifpb.sorveteria.app;


import ifpb.sorveteria.factory.itens.SorveteFactory;
import ifpb.sorveteria.model.Pedido;

public class Main {
    public static void main(String[] args) throws Exception {

        Pedido pedido = new Pedido();

        pedido.adicionarPedidoALista(new SorveteFactory().criarItem("Chocolate"));
        pedido.adicionarPedidoALista(new SorveteFactory().criarItem("Morango"));
        pedido.adicionarPedidoALista(new SorveteFactory().criarItem("Baunilha"));

        System.out.println(pedido.listarPedidos());
    }
}
