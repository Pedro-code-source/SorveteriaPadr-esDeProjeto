package com.sorveteria.sorveteria.State;

import com.sorveteria.sorveteria.Observer.Pedido;

public class PedidoCancelado implements EstadoPedido {

    public void entregar(Pedido pedido){
        System.out.println("Não é possível, pois o pedido foi CANCELADO!");
    }

    public void cancelar(Pedido pedido){
        System.out.println("Não é possível, pois o pedido foi CANCELADO!");
    }

    public void receber(Pedido pedido){
        System.out.println("Não é possível, pois o pedido foi CANCELADO!");
    }

    public void preparar(Pedido pedido){
        System.out.println("Não é possível, pois o pedido foi CANCELADO!");
    }
}
