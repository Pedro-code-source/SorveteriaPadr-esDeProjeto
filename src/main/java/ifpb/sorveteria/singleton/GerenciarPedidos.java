package ifpb.sorveteria.singleton;

import ifpb.sorveteria.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class GerenciarPedidos {

    private static GerenciarPedidos instance;
    private List<Pedido> pedidos;

    private GerenciarPedidos() {
        pedidos = new ArrayList<>();
    }

    public static GerenciarPedidos getInstance() {
        if (instance == null) {
            instance = new GerenciarPedidos();
        }
        return instance;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void listarPedidos() {
        System.out.println("\n📦 Lista de pedidos registrados:");
        System.out.println("=".repeat(40));

        if (pedidos.isEmpty()) {
            System.out.println("🔎 Nenhum pedido registrado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.printf("🧾 Pedido #%d\n", pedido.getIdPedido());
            System.out.printf("💰 Valor final: R$%.2f\n", pedido.getValorFinal());
            System.out.printf("📌 Estado: %s\n", pedido.getEstadoDoPedido().getClass().getSimpleName());
            System.out.println("🍧 Itens do pedido:");
            pedido.exibirItens(); // exibe os sabores e personalizações
            System.out.println("-".repeat(40));
        }

        System.out.printf("✅ Total de pedidos: %d\n", pedidos.size());
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

