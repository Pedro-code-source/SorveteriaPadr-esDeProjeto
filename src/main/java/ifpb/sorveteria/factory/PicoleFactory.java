package ifpb.sorveteria.factory;

import ifpb.sorveteria.model.Picole;

public class PicoleFactory implements ItemFactory{
    @Override
    public Picole criarItem(String sabor) {
        return new Picole(sabor);
    }
}
