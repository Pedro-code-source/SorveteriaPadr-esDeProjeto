package ifpb.sorveteria.model.adicionais;

public class Cobertura {

    private String nomeCobertura;
    private double preco;

    public Cobertura(String nomeAdicional, double precoBase) {
        this.nomeCobertura = nomeAdicional;
        this.preco = precoBase;
    }

    public String getNomeCobertura() {
        return nomeCobertura;
    }

    public void setNomeCobertura(String nomeCobertura) {
        this.nomeCobertura = nomeCobertura;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
