package ifpb.sorveteria.model.adicionais;

public class Granulado {

    private String nomeGranulado;
    private double preco;

    public Granulado(String nomeCalda, double preco) {
        this.nomeGranulado = nomeCalda;
        this.preco = preco;
    }

    public String getNomeGranulado() {
        return nomeGranulado;
    }

    public void setNomeGranulado(String nomeGranulado) {
        this.nomeGranulado = nomeGranulado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
