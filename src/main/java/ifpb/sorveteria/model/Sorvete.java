package ifpb.sorveteria.model;

import ifpb.sorveteria.Interfaces.Item;

public class Sorvete implements Item {
    private String sabor;
    private double preco;

    public Sorvete(String sabor){
        this.sabor = "Sorvete de " + sabor;
        this.preco = 4.0;

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
