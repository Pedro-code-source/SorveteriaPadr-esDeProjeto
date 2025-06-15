package com.sorveteria.sorveteria.Observer;

import com.sorveteria.sorveteria.model.StatusPedido;

public class Cliente implements Observer {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(StatusPedido status) {
        System.out.println(nome + " seu pedido agora está: " + status);
    }
}
