package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public interface EstadoPedido {
    void pedidoRecebido(Pedido pedido) throws Exception;
    void pedidoPreparando(Pedido pedido) throws Exception;
    void pedidoFinalizado(Pedido pedido) throws Exception;
}
