package com.sorveteria.sorveteria.State;

import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.model.StatusPedido;

public class PedidoPreparando implements EstadoPedido{


    public void receber(Pedido pedido) {
        System.out.println("Pedido já está em preparo, não pode ser recebido de novo.");
    }

    public void cancelar(Pedido pedido){
        System.out.println("Não é possível cancelar!");
    }

    public void preparar(Pedido pedido){
        pedido.setStatusPedido(StatusPedido.PEDIDO_PREPARANDO);
        pedido.setEstado(new PedidoPronto());
    }

    public void entregar(Pedido pedido){
        System.out.println("Pedido ainda não está pronto!");
    }
}
