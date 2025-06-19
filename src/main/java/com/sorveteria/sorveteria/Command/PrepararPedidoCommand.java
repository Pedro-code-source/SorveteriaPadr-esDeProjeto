package com.sorveteria.sorveteria.Command;

import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.model.StatusPedido;

public class PrepararPedidoCommand implements Command {

    private Pedido pedido;

    public PrepararPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        pedido.setStatusPedido(StatusPedido.PEDIDO_PREPARANDO);
        System.out.println("Pedido está em preparo com o Status: " + StatusPedido.PEDIDO_PREPARANDO);
    }
}
