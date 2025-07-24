package ifpb.sorveteria.Interfaces;

import ifpb.sorveteria.model.Pedido;

import java.util.List;

public interface PedidoRepositoryInterface {
    void salvar(Pedido pedido);
    Pedido buscarPorId(int id);
    List<Pedido> listarTodos();
    void remover(int id);
}
