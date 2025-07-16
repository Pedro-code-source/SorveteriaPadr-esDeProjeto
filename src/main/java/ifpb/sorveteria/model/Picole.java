package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.Item;

public class Picole implements Item {
    private String sabor;
    private double preco;

    public Picole(String sabor){
        this.sabor = "Picolé de " + sabor;
        this.preco = 2.00;
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
