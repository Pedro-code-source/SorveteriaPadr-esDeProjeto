package ifpb.sorveteria.factory.itens;

public interface ItemFactory<T> {
    T criarItem(String nomeItem);
}
