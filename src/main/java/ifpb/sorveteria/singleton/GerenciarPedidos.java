package ifpb.sorveteria.singleton;

import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.strategy.Desconto;

import java.util.ArrayList;
import java.util.List;

public class GerenciarPedidos {

    private static GerenciarPedidos instance;
    private List<Pedido> pedidos;
    Desconto desconto = new Desconto();


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
        int contReverso = pedidos.size();

        if (pedidos.isEmpty()) {
            System.out.println("🔎 Nenhum pedido registrado.");
            return;
        }
        for (Pedido pedido : pedidos) {
            contReverso--;
            System.out.printf("🧾 Pedido #%d\n", pedido.getIdPedido()-contReverso);
            System.out.printf("💰 Valor final: R$%.2f\n", pedido.calcularValorFinal() - ((desconto.getDesconto() / 100) * pedido.calcularValorFinal()));
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

