package ifpb.sorveteria.factory.itens;

import ifpb.sorveteria.model.itens.Sorvete;

import java.util.Map;

public class SorveteFactory implements ItemFactory<Sorvete> {

    private static final Map<String, Double> tabelaDePrecos = Map.of(
            "Morango", 4.0,
            "Chocolate", 4.5,
            "Baunilha", 3.8
    );

    @Override
    public Sorvete criarItem(String nomeItem) {
        Double precoBase = tabelaDePrecos.get(nomeItem.toLowerCase());

        if (precoBase == null) {
            throw new IllegalArgumentException("Sabor '" + nomeItem + "' não encontrado.");
        }

        return new Sorvete(nomeItem, precoBase);
    }
}
