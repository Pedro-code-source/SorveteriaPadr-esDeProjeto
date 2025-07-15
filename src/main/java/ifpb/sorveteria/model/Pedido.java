package ifpb.sorveteria.model;

import ifpb.sorveteria.state.EstadoPedido;
import ifpb.sorveteria.state.PedidoRecebido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido <T>{

    private ArrayList <T> listaPedidos = new ArrayList<T>();
    private double valorFinal;
    private EstadoPedido estadoPedido = new PedidoRecebido();

    public Pedido() {
        this.valorFinal = 0;
    }

    public ArrayList<T> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<T> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void adicionarPedidoALista(T pedido) {
        listaPedidos.add(pedido);
    }

    public List<String> listarPedidos() {
        return listaPedidos.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public void pedidoRecebido() throws Exception {
        this.estadoPedido.pedidoRecebido(this);
    }

    public void pedidoPreparando() throws Exception {
        this.estadoPedido.pedidoPreparando(this);
    }

    public void pedidoFinalizado() throws Exception {
        this.estadoPedido.pedidoFinalizado(this);
    }
}
