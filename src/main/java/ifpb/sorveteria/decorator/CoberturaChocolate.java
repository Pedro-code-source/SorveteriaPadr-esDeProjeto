package ifpb.sorveteria.decorator;

import ifpb.sorveteria.Interfaces.Item;

public class CoberturaChocolate extends AdicionalDecorator{

    public CoberturaChocolate(Item item){
        super(item);
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 1.00;
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com cobertura de Chocolate";
    }
}
