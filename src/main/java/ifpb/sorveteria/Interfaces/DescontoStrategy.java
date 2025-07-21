package ifpb.sorveteria.Interfaces;

import ifpb.sorveteria.model.Pedido;

public interface DescontoStrategy {
    double calcularDesconto(Pedido pedido);
}
