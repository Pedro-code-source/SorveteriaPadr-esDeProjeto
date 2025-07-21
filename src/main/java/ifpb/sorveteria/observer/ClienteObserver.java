package ifpb.sorveteria.observer;

import ifpb.sorveteria.Interfaces.Observer;

public class ClienteObserver implements Observer {
    private String nome;

    public ClienteObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Pedido de " + nome + ": " + mensagem);
    }
}
