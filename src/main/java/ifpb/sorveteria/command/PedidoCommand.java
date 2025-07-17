package ifpb.sorveteria.command;

import ifpb.sorveteria.model.Pedido;

import java.util.ArrayList;

public class PedidoCommand implements Command {
    private ArrayList<Pedido> pedidos;

    public PedidoCommand() {
        this.pedidos = new ArrayList<>();
    }

    private void atualizarIds() {
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.get(i).setIdPedido(i + 1);
        }
    }

    @Override
    public void fazer(Pedido pedido) throws Exception{
        if (pedidos.contains(pedido)) {
            throw new Exception("O pedido já existe na lista!");
        } else {
            pedidos.add(pedido);
            atualizarIds();
            System.out.println("Pedido: " + pedido.getIdPedido() + " adicionado com sucesso!");
        }
    }

    @Override
    public void desfazer(Pedido pedido) throws Exception {
        if (pedidos.contains(pedido)) {
            pedidos.remove(pedido);
            atualizarIds();
            System.out.println("Pedido: " + pedido.getIdPedido() + " removido com sucesso!");
        } else {
            throw new Exception("Pedido não encontrado!");
        }
    }

    public void verificarIdPedido() {
        for (Pedido p : pedidos) {
            System.out.println(p.getIdPedido());
        }
    }
}
