package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public class PedidoRecebido implements EstadoPedido {

    @Override
    public void pedidoRecebido(Pedido pedido) throws Exception {
        throw new Exception("O pedido já foi recebido e está em preparo!");
    }

    @Override
    public void pedidoPreparando(Pedido pedido) throws Exception {
        pedido.setEstadoPedido(new PedidoPreparando());
    }

    @Override
    public void pedidoFinalizado(Pedido pedido) throws Exception {
        throw new Exception("O pedido já foi recebido e está em preparo!");
    }
}
