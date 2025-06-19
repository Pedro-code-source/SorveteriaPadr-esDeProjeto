package com.sorveteria.sorveteria.Command;

import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.Singleton.FilaPedidoSingleton;
import com.sorveteria.sorveteria.model.StatusPedido;

public class FazerPedidoCommand implements Command {

    private Pedido pedido;

    public FazerPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        pedido.setStatusPedido(StatusPedido.PEDIDO_RECEBIDO);
        FilaPedidoSingleton.getInstance().addPedido(pedido);
        System.out.println("Pedido adicionado à fila com status: " + StatusPedido.PEDIDO_RECEBIDO);
    }
}
