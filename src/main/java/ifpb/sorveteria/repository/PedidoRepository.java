package ifpb.sorveteria.repository;

import ifpb.sorveteria.model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoRepository{
    private Map<Integer, Pedido> pedidos = new HashMap<>();


    public void salvar(Pedido pedido) {
        int id = pedido.getIdPedido();
        if(pedidos.containsKey(id)){
            System.out.println("Erro: Já existe um pedido com ID" + id);
            return;
        }
        pedidos.put(pedido.getIdPedido(), pedido);
    }


    public Pedido buscarPorId(int id) {
        return pedidos.get(id);
    }


    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }


    public void remover(int id) {
        pedidos.remove(id);
    }
}
