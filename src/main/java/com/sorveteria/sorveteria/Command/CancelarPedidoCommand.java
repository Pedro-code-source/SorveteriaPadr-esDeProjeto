package com.sorveteria.sorveteria.Command;

import com.sorveteria.sorveteria.Observer.Observer;
import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.Singleton.FilaPedidoSingleton;
import com.sorveteria.sorveteria.model.StatusPedido;

public class CancelarPedidoCommand implements Command {

    private Pedido pedido;

    public CancelarPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        pedido.setStatusPedido(StatusPedido.PEDIDO_CANCELADO);
        FilaPedidoSingleton.getInstance().removePedido(pedido);
        System.out.println("Pedido removido da fila com status: " + StatusPedido.PEDIDO_CANCELADO);
    }
}
