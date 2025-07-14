package ifpb.sorveteria.factory;

public interface ItemFactory<T> {
    T criarItem(String sabor);
}
