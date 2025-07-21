package ifpb.sorveteria.factory;

import ifpb.sorveteria.Interfaces.ItemFactory;
import ifpb.sorveteria.model.MilkShake;

public class MilkShakeFactory implements ItemFactory {

    @Override
    public MilkShake criarItem(String sabor) {
        return new MilkShake(sabor);
    }
}
