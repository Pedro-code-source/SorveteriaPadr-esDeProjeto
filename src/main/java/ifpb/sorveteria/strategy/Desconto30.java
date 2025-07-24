package ifpb.sorveteria.strategy;

import ifpb.sorveteria.Interfaces.DescontoStrategy;
import ifpb.sorveteria.model.Pedido;

public class Desconto30 implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal * 0.30;
    }
}
