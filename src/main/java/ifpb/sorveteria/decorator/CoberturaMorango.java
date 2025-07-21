package ifpb.sorveteria.decorator;

import ifpb.sorveteria.Interfaces.Item;

public class CoberturaMorango extends AdicionalDecorator{
    public CoberturaMorango (Item item){
        super(item);
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com cobertura de Morango";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 1.00;
    }
}
