package ifpb.sorveteria.factory.adicionais;

public interface AdicionalFactory<T> {
    T criarAdicional(String nomeAdicional);
}
