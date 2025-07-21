package ifpb.sorveteria.strategy;

import ifpb.sorveteria.Interfaces.DescontoStrategy;
import ifpb.sorveteria.model.Pedido;

public class Desconto30 implements DescontoStrategy {

    @Override
    public double calcularDesconto(Pedido pedido) {
        return pedido.getValorFinal() - (pedido.getValorFinal() * 0.30);
    }
}
