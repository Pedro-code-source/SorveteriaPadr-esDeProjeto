package ifpb.sorveteria.factory.itens;

import ifpb.sorveteria.model.itens.MilkShake;

public class MilkShakeFactory implements ItemFactory<MilkShake> {

    @Override
    public MilkShake criarItem(String nomeItem) {
        return new MilkShake(nomeItem);
    }
}
