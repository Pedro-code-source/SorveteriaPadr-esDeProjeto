package com.sorveteria.sorveteria.Observer;

import com.sorveteria.sorveteria.State.EstadoPedido;
import com.sorveteria.sorveteria.model.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    EstadoPedido estado;

    StatusPedido statusPedido;

    List<Observer> obs = new ArrayList();

    public Pedido(EstadoPedido estado) {
        this.estado = estado;
    }

    public void addObserver(Observer ob){
        obs.add(ob);
    }

    public void removeObserver(Observer ob){
        obs.remove(ob);
    }

    public void setStatusPedido(StatusPedido statusPedido){
        this.statusPedido = statusPedido;
        notifyObservers();
    }

    public void notifyObservers(){
        for(Observer ob:obs){
            ob.atualizar(statusPedido);
        }
    }

    public void setEstado(EstadoPedido estado){
        this.estado = estado;
        notifyObservers();
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
