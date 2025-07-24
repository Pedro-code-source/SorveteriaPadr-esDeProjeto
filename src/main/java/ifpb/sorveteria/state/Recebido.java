package ifpb.sorveteria.state;

import ifpb.sorveteria.Interfaces.EstadoPedido;
import ifpb.sorveteria.model.Pedido;

public class Recebido implements EstadoPedido {
    @Override
    public void mudarParaRecebido(Pedido pedido) {
        System.out.println("Pedido está agora em estado: Recebido");
    }

    @Override
    public void mudarParaPreparando(Pedido pedido) {
        pedido.setEstadoDoPedido(new Preparando());
    }

    @Override
    public void mudarParaFinalizado(Pedido pedido) throws Exception {
        throw new Exception("Não é possível finalizar um pedido que acabou de ser recebido.");
    }
}
