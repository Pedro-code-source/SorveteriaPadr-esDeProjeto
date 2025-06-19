package com.sorveteria.sorveteria.Testes;

import com.sorveteria.sorveteria.Observer.Observer;
import com.sorveteria.sorveteria.Observer.Pedido;
import com.sorveteria.sorveteria.State.PedidoRecebido;
import com.sorveteria.sorveteria.model.StatusPedido;

public class TesteState {

    public static void main(String[] args) {

        Observer cliente = new Observer() {
            @Override
            public void atualizar(StatusPedido status) {
                System.out.println("Cliente foi notificado: Status = " + status);
            }
        };

        Pedido pedido = new Pedido(new PedidoRecebido());
        pedido.addObserver(cliente);

        System.out.println("\n Estado Inicial: PedidoRecebido");
        pedido.getEstado().preparar(pedido);

        System.out.println("\n Estado após preparar: PedidoPreparando");
        pedido.getEstado().preparar(pedido);

        System.out.println("\n Estado após preparar novamente: PedidoPronto");
        pedido.getEstado().entregar(pedido);

        System.out.println("\n Tentando Cancelar após entrega:");
        pedido.getEstado().cancelar(pedido);

        System.out.println("\n Fim");
    }
}
