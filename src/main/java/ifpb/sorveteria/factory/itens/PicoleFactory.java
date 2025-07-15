package ifpb.sorveteria.factory.itens;

import ifpb.sorveteria.model.itens.Picole;

import java.util.Map;

public class PicoleFactory implements ItemFactory<Picole> {

    private static final Map<String, Double> tabelaDePrecos = Map.of(
            "Morango", 2.0,
            "Chocolate", 2.0,
            "Leite Condensado", 3.0
    );

    @Override
    public Picole criarItem(String nomeItem) {
        Double precoBase = tabelaDePrecos.get(nomeItem);

        return new Picole(nomeItem, precoBase);
    }
}
