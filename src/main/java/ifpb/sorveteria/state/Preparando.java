package ifpb.sorveteria.state;

import ifpb.sorveteria.Interfaces.EstadoPedido;
import ifpb.sorveteria.model.Pedido;

public class Preparando implements EstadoPedido {

    @Override
    public void mudarParaRecebido(Pedido pedido) throws Exception{
        throw new Exception("O pedido já está sendo preparado!");
    }

    @Override
    public void mudarParaPreparando(Pedido pedido) {
        System.out.println("Pedido está agora em estado: Preparando");
    }

    @Override
    public void mudarParaFinalizado(Pedido pedido) {
        pedido.setEstadoDoPedido(new Finalizado());
    }
}
