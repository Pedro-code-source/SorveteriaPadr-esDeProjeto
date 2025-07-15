package ifpb.sorveteria.model.itens;

public class MilkShake {
    private String sabor;
    private double preco;

    public MilkShake(String sabor){
        this.sabor = "Milkshake de " + sabor;
        this.preco = 7.00;
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
