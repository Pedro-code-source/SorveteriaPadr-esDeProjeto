package ifpb.sorveteria.model.itens;

public class Picole {
    private String sabor;
    private double preco;

    public Picole(String sabor, double precoBase){
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
}
