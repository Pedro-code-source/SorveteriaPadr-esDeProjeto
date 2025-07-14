package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.AdicionalFactory;

public class Sorvete implements AdicionalFactory {
    private String sabor;
    private double preco;

    public Sorvete(String sabor){
        this.sabor = "Sorvete de " + sabor;
        this.preco = 4.0;

    }

    @Override
    public void adicionar(String adicional,String tipo, double preco) {
        setPreco(getPreco()+preco);
        setSabor(getSabor() + " com " + tipo + " de " + adicional + " valor: " + getPreco());
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
