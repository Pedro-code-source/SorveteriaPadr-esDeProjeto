package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.Item;
import ifpb.sorveteria.state.EstadoPedido;
import ifpb.sorveteria.state.Recebido;

import java.util.ArrayList;

public class Pedido<T extends Item> {

    ArrayList<T> pedidos = new ArrayList<T>();
    private double valorFinal;
    private EstadoPedido estadoDoPedido = new Recebido();

    public ArrayList<T> getPedidos() {
        return pedidos;
    }

    public Pedido(){
        this.valorFinal = 0;
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

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public void setEstadoDoPedido(EstadoPedido estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }

    public EstadoPedido getEstadoDoPedido() {
        return estadoDoPedido;
    }

    public void recebido() throws Exception {
        this.estadoDoPedido.recebido(this);
    }

    public void preparando() throws Exception {
        this.estadoDoPedido.preparando(this);
    }

    public void finalizado() throws Exception {
        this.estadoDoPedido.finalizado(this);
    }

}
