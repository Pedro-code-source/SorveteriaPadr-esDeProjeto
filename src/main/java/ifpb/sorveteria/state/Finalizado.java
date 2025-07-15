package ifpb.sorveteria.state;

import ifpb.sorveteria.model.Pedido;

public class Finalizado implements EstadoPedido{

    @Override
    public void recebido(Pedido pedido) throws Exception{
        throw new Exception("O pedido já foi entregue!");
    }

    @Override
    public void preparando(Pedido pedido) throws Exception{
        throw new Exception("O pedido já foi entregue!");
    }

    @Override
    public void finalizado(Pedido pedido) throws Exception{
        throw new Exception("O pedido já foi entregue!");
    }
}
