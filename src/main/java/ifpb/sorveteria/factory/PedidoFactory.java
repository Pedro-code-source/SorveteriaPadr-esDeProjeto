package ifpb.sorveteria.factory;

import ifpb.sorveteria.model.Pedido;

public class PedidoFactory {

    public Pedido criarPedido(){
      return new Pedido();
    }
}
