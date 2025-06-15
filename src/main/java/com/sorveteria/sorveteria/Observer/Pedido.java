package com.sorveteria.sorveteria.Observer;

import com.sorveteria.sorveteria.model.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    StatusPedido statusPedido;

    List<Observer> obs = new ArrayList();

    public Pedido() {
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

}
