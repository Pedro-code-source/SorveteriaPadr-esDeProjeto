package ifpb.sorveteria.model.itens;

public class Sorvete {
    private String sabor;
    private double preco;

    public Sorvete(String sabor, double precoBase) {
        this.sabor = sabor;
        this.preco = precoBase;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Sorvete de " + sabor + " - R$ " + preco;
    }
}