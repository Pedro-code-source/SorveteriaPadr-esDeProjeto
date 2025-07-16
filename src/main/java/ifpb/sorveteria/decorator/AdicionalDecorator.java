package ifpb.sorveteria.decorator;

import ifpb.sorveteria.factory.Item;

public abstract class AdicionalDecorator implements Item {
    protected Item item;

    public AdicionalDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getSabor() {
        return item.getSabor();
    }

    @Override
    public double getPreco() {
        return item.getPreco();
    }
}
