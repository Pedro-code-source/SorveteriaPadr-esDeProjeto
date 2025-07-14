package ifpb.sorveteria.model;

import ifpb.sorveteria.factory.AdicionalFactory;

public class Picole implements AdicionalFactory {
    private String sabor;
    private double preco;

    public Picole(String sabor){
        this.sabor = "Picolé de " + sabor;
        this.preco = 2.00;
    }


    @Override
    public void adicionar(String adicional,String tipo, double preco) {
        setPreco(getPreco()+preco);
        System.out.println("Sorvete de " + getSabor() + " com " + tipo + " de " + adicional + " valor: " + getPreco());
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
