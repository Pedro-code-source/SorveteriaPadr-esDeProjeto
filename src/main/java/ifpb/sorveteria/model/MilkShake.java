package ifpb.sorveteria.model;

import ifpb.sorveteria.Interfaces.Item;

public class MilkShake implements Item {
    private String sabor;
    private double preco;

    public MilkShake(String sabor){
        this.sabor = "Milkshake de " + sabor;
        this.preco = 7.00;
    }

    @Override
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
