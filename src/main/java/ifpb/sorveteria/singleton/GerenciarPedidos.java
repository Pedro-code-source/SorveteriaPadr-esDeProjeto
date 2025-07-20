package ifpb.sorveteria.singleton;

import ifpb.sorveteria.model.Pedido;

import java.util.ArrayList;

public class GerenciarPedidos {
    private static GerenciarPedidos instance;
    ArrayList<Pedido> pedidos;
    private GerenciarPedidos(){
        pedidos = new ArrayList<>();
    }

    public static GerenciarPedidos getInstance(){
        if (instance == null){
            instance = new GerenciarPedidos();
        }
        return instance;
    }

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    };

    public void removerPedido(Pedido pedido){
        pedidos.remove(pedido);
    };

    public void listarPedidos(){
        for (int i = 0; i < pedidos.size();i++){
            System.out.println("Pedido " + (i+1));
            pedidos.get(i).listarItens();
        }
        }
    };


