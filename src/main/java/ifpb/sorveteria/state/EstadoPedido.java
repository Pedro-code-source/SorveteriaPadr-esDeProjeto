package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public interface EstadoPedido {
    public void recebido(Pedido pedido) throws Exception;
    public void preparando(Pedido pedido) throws Exception;
    public void finalizado(Pedido pedido) throws Exception;
}
