package ifpb.sorveteria.services;

import ifpb.sorveteria.Interfaces.Item;

import java.util.List;

public class CalculadoraDeValor {

    public double calcularValorDosItens(List<Item> itens) {
        return itens.stream().mapToDouble(Item::getPreco).sum();
    }
}
