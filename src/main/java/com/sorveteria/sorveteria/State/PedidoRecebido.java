package com.sorveteria.sorveteria.State;

import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.model.StatusPedido;

public class PedidoRecebido implements EstadoPedido{

    public void preparar(Pedido pedido){
        pedido.setStatusPedido(StatusPedido.PEDIDO_PREPARANDO);
        pedido.setEstado(new PedidoPreparando());
    }

    public void cancelar(Pedido pedido){
        pedido.setStatusPedido(StatusPedido.PEDIDO_CANCELADO);
        pedido.setEstado(new PedidoCancelado());
    }

    public void receber(Pedido pedido){
        System.out.println("Ação não permitida no momento!");
    }

    public void entregar(Pedido pedido){
        System.out.println("Ação não permitida no momento!");
    }
}
