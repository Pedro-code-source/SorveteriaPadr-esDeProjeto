package ifpb.sorveteria.strategy;

import ifpb.sorveteria.model.Pedido;

public interface DescontoStrategy {
    double calcularDesconto(Pedido pedido);
}
