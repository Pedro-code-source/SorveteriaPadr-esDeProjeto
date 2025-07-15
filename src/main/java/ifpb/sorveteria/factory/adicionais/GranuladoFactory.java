package ifpb.sorveteria.factory.adicionais;

import ifpb.sorveteria.model.adicionais.Granulado;

import java.util.Map;

public class GranuladoFactory implements AdicionalFactory<Granulado> {

    private static final Map<String, Double> tabelaDePrecos = Map.of(
            "Chocolate", 0.5,
            "Colorido", 1.0
    );

    @Override
    public Granulado criarAdicional(String nomeAdicional) {
        Double precoBase = tabelaDePrecos.get(nomeAdicional);

        return new Granulado(nomeAdicional, precoBase);
    }
}
