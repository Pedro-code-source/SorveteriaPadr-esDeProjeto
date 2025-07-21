package ifpb.sorveteria.strategy;

import ifpb.sorveteria.Interfaces.DescontoStrategy;
import ifpb.sorveteria.model.Pedido;

public class Desconto20 implements DescontoStrategy {

    @Override
    public double calcularDesconto(Pedido pedido) {
        return pedido.getValorFinal() - (pedido.getValorFinal() * 0.20);
    }
}
