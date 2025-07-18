package ifpb.sorveteria.strategy;

import ifpb.sorveteria.model.Pedido;

public class Desconto10 implements DescontoStrategy {

    @Override
    public double calcularDesconto(Pedido pedido) {
        return pedido.getValorFinal() - (pedido.getValorFinal() * 0.10);
    }
}
