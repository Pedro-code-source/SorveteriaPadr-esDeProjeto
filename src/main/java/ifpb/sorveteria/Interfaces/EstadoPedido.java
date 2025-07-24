package ifpb.sorveteria.Interfaces;

import ifpb.sorveteria.model.Pedido;

public interface EstadoPedido {
    void mudarParaRecebido(Pedido pedido) throws Exception;
    void mudarParaPreparando(Pedido pedido) throws Exception;
    void mudarParaFinalizado(Pedido pedido) throws Exception;
}
