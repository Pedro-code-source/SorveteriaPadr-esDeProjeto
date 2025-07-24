package ifpb.sorveteria.services;

import ifpb.sorveteria.Interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeItens {
    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public void removerItem(Item item){
        itens.remove(item);
    }

    public List<Item> obterItens() {
        return itens;
    }
}
