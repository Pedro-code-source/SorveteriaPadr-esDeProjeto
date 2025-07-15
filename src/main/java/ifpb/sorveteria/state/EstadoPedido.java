package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public interface EstadoPedido {
    void recebido(Pedido pedido) throws Exception;
    void preparando(Pedido pedido) throws Exception;
    void finalizado(Pedido pedido) throws Exception;
}
