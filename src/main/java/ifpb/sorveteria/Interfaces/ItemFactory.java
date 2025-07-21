package ifpb.sorveteria.Interfaces;

public interface ItemFactory<T> {
    T criarItem(String sabor);
}
