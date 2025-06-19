package com.sorveteria.sorveteria.State;

import com.sorveteria.sorveteria.Observer.Pedido;

public interface EstadoPedido {

    void receber(Pedido pedido);
    void preparar(Pedido pedido);
    void cancelar(Pedido pedido);
    void entregar(Pedido pedido);

}
