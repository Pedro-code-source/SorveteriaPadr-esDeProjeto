package ifpb.sorveteria.decorator;

import ifpb.sorveteria.factory.Item;

public class AdicionalGotasChocolate extends AdicionalDecorator{

    public AdicionalGotasChocolate(Item item ){
        super(item);
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com adicional de Gotas de Chocolate";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 2.00;
    }
}
