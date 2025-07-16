package ifpb.sorveteria.decorator;

import ifpb.sorveteria.factory.Item;

public class CoberturaUva extends AdicionalDecorator {

    public CoberturaUva(Item item){
        super(item);
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com cobertura de Uva";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 1.00;
    }
}
