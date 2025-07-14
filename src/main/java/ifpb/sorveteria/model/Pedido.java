package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.AdicionalFactory;
import ifpb.sorveteria.factory.MilkShakeFactory;
import ifpb.sorveteria.factory.SorveteFactory;

import java.awt.*;
import java.util.ArrayList;

public class Pedido<T extends AdicionalFactory> {

    ArrayList<T> pedidos = new ArrayList<T>();
    private double valorFinal;
    private String statusDoPedido;

    public ArrayList<T> getPedidos() {
        return pedidos;
    }

    public Pedido(){
        this.valorFinal = 0;
    }

    public double getValorFinal() {
        for (AdicionalFactory i : pedidos){
            valorFinal += i.getPreco();
        }
        return valorFinal;
    }

    public void listarPedidos(){
        int contador = 0;
        for (AdicionalFactory i : pedidos){
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

    public String getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(String statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
}
