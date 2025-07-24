package ifpb.sorveteria.strategy;

import ifpb.sorveteria.Interfaces.DescontoStrategy;
import ifpb.sorveteria.model.Pedido;

public class Desconto20 implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - (valorOriginal * 0.20);
    }
}
