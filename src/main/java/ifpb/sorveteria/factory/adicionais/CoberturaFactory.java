package ifpb.sorveteria.factory.adicionais;

import ifpb.sorveteria.model.adicionais.Cobertura;

import java.util.Map;

public class CoberturaFactory implements AdicionalFactory<Cobertura> {

    private static final Map<String, Double> tabelaDePrecos = Map.of(
            "Morango", 2.0,
            "Chocolate", 2.5,
            "Menta", 2.8
    );

    @Override
    public Cobertura criarAdicional(String nomeAdicional) {
        Double precoBase = tabelaDePrecos.get(nomeAdicional);

        return new Cobertura(nomeAdicional, precoBase);
    }
}
