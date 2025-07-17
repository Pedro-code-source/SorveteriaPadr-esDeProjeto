package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.Item;
import ifpb.sorveteria.observer.Observer;
import ifpb.sorveteria.state.EstadoPedido;
import ifpb.sorveteria.state.Recebido;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T extends Item> {

    ArrayList<T> pedidos = new ArrayList<T>();
    private double valorFinal;
    private EstadoPedido estadoDoPedido = new Recebido();
    private List<Observer> observers = new ArrayList();
    private int idPedido;

    public Pedido(){
        this.valorFinal = 0;
    }

    public void adicionarObserver(Observer o) {
        observers.add(o);
    }

    public void removerObserver(Observer o) {
        observers.remove(o);
    }

    public void notificarObservers(String mensagem) {
        for (Observer o : observers) {
            o.atualizar(mensagem);
        }
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ArrayList<T> getPedidos() {
        return pedidos;
    }

    public double getValorFinal() {
        for (Item i : pedidos){
            valorFinal += i.getPreco();
        }
        return valorFinal;
    }

    public void listarPedidos(){
        int contador = 0;
        for (Item i : pedidos){
            contador ++;
            System.out.println(contador + "- " + i.getSabor());
        }
    }

    public void adicionarPedido(T pedido){
        pedidos.add(pedido);
    }

    public double setValorFinal(double valorFinal) {
        return this.valorFinal = valorFinal;
    }

    public void setEstadoDoPedido(EstadoPedido estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }

    public EstadoPedido getEstadoDoPedido() {
        return estadoDoPedido;
    }

    public void recebido() throws Exception {
        this.estadoDoPedido.recebido(this);
        notificarObservers("Recebido.");
    }

    public void preparando() throws Exception {
        this.estadoDoPedido.preparando(this);
        notificarObservers("Preparando.");
    }

    public void finalizado() throws Exception {
        this.estadoDoPedido.finalizado(this);
        notificarObservers("Finalizado.");
    }

}
