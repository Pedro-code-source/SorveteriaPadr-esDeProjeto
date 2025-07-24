package ifpb.sorveteria.state;

import ifpb.sorveteria.Interfaces.EstadoPedido;
import ifpb.sorveteria.model.Pedido;

public class Finalizado implements EstadoPedido {

    @Override
    public void mudarParaRecebido(Pedido pedido) throws Exception{
        throw new Exception("O pedido já foi entregue!");
    }

    @Override
    public void mudarParaPreparando(Pedido pedido) throws Exception{
        throw new Exception("O pedido já foi entregue!");
    }

    @Override
    public void mudarParaFinalizado(Pedido pedido) {
        System.out.println("Pedido está agora em estado: Finalizado");
    }
}
