package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public class Recebido implements EstadoPedido{
    @Override
    public void recebido(Pedido pedido) throws Exception {
        throw new Exception("O pedido já foi recebido e está em preparo!");
    }

    @Override
    public void preparando(Pedido pedido){
        pedido.setEstadoDoPedido(new Preparando());
    }

    @Override
    public void finalizado(Pedido pedido) throws Exception {
        throw new Exception("O pedido já foi recebido e está em preparo!");
    }
}
