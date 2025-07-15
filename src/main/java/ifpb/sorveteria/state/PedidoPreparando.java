package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public class PedidoPreparando implements EstadoPedido {

    @Override
    public void pedidoRecebido(Pedido pedido) throws Exception {
        throw new Exception("O pedido já está preparando!");
    }

    @Override
    public void pedidoPreparando(Pedido pedido) throws Exception {
        throw new Exception("O pedido já está preparando!");
    }

    @Override
    public void pedidoFinalizado(Pedido pedido) throws Exception {
        pedido.setEstadoPedido(new PedidoFinalizado());
    }
}
