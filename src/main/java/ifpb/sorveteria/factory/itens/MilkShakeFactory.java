package ifpb.sorveteria.factory.itens;

import ifpb.sorveteria.model.itens.MilkShake;

import java.util.Map;

public class MilkShakeFactory implements ItemFactory<MilkShake> {

    private Map<String, Double> tabelaDePrecos = Map.of(
            "Morango", 7.0,
            "Chocolate", 8.5,
            "Limão", 5.0
    );

    @Override
    public MilkShake criarItem(String nomeItem) {
        Double precoBase = tabelaDePrecos.get(nomeItem);

        return new MilkShake(nomeItem, precoBase);
    }
}
