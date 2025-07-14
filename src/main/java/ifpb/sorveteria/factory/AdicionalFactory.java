package ifpb.sorveteria.factory;

public interface AdicionalFactory {
    String getSabor();
    double getPreco();
    void adicionar(String cobertura,String tipo,double preco);
}
