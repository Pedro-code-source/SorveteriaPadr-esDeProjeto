package ifpb.sorveteria.services;

import ifpb.sorveteria.Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificadorDePedido {
    private List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer o){
        observers.add(o);
    }

    public void removerObserver(Observer o){
        observers.remove(o);
    }

    public void notificar(String mensagem){
        observers.forEach(o -> o.atualizar(mensagem));
    }
}
