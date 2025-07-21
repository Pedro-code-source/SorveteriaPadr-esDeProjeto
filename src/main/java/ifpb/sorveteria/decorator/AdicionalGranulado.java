package ifpb.sorveteria.decorator;

import ifpb.sorveteria.Interfaces.Item;

public class AdicionalGranulado extends AdicionalDecorator{

    public AdicionalGranulado (Item item){
        super(item);
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 2.00;
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com adicional de Granulado";
    }
}
