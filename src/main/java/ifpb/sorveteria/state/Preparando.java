package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public class Preparando implements EstadoPedido{
    @Override
    public void recebido(Pedido pedido) throws Exception{
        throw new Exception("O pedido já está sendo preparado!");
    }

    @Override
    public void preparando(Pedido pedido) throws Exception{
        throw new Exception("O pedido já está sendo preparado!");
    }

    @Override
    public void finalizado(Pedido pedido) {
        pedido.setEstadoDoPedido(new Finalizado());
    }
}
