package com.sorveteria.sorveteria.Singleton;

import com.sorveteria.sorveteria.Observer.Pedido;

import java.util.ArrayList;
import java.util.List;

public class FilaPedidoSingleton {

    private List<Pedido> pedidos =  new ArrayList<>();
    private static FilaPedidoSingleton instance;

    private FilaPedidoSingleton() {
    }

    public static FilaPedidoSingleton getInstance() {
        if (instance == null) {
            instance = new FilaPedidoSingleton();
        }
        return instance;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public List<Pedido> getPedidos(){
        return pedidos;
    }
}
