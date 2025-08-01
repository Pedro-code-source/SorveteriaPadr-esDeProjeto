package ifpb.sorveteria.factory;

import ifpb.sorveteria.model.Pedido;

public class PedidoFactory {

//    private static int contador = 0;
public Pedido criarPedido(){
        return new Pedido();
    }
}
