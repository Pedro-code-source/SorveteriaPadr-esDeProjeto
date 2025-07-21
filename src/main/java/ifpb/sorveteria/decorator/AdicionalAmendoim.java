package ifpb.sorveteria.decorator;

import ifpb.sorveteria.Interfaces.Item;

public class AdicionalAmendoim extends AdicionalDecorator{

    public AdicionalAmendoim(Item item){
        super(item);
    }

    @Override
    public String getSabor() {
        return item.getSabor() + " com adicional de Amendoim";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 2.00;
    }
}
