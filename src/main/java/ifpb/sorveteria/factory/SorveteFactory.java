package ifpb.sorveteria.factory;

import ifpb.sorveteria.Interfaces.ItemFactory;
import ifpb.sorveteria.model.Sorvete;

public class SorveteFactory implements ItemFactory {

    @Override
    public Sorvete criarItem(String sabor) {
        return new Sorvete(sabor);
    }
}
