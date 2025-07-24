package ifpb.sorveteria.factory;

import ifpb.sorveteria.model.Pedido;

public class PedidoFactory {

    private static int contador = 100;

    public Pedido criarPedido(){
        Pedido pedido = new Pedido();
        pedido.setIdPedido(contador++);
        return pedido;
    }
}
