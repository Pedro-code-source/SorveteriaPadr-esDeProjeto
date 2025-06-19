package com.sorveteria.sorveteria.State;

import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.model.StatusPedido;

public class PedidoPronto implements EstadoPedido{

    public void entregar(Pedido pedido){
        pedido.setStatusPedido(StatusPedido.PEDIDO_ENTREGUE);
    }

    public void cancelar(Pedido pedido){
        System.out.println("Não é possível fazer isso agora. O pedido já está pronto para entrega.");
    }

    public void preparar(Pedido pedido){
        System.out.println("Não é possível fazer isso agora. O pedido já está pronto para entrega.");
    }

    public void receber(Pedido pedido){
        System.out.println("Não é possível fazer isso agora. O pedido já está pronto para entrega.");
    }
}
