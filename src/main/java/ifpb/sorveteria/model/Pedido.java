package ifpb.sorveteria.model;

import ifpb.sorveteria.Interfaces.Item;
import ifpb.sorveteria.Interfaces.EstadoPedido;
import ifpb.sorveteria.state.Recebido;
import ifpb.sorveteria.services.CarrinhoDeItens;
import ifpb.sorveteria.services.CalculadoraDeValor;
import ifpb.sorveteria.services.NotificadorDePedido;

public class Pedido {

    private static int idPedido = 0;
    private double valorFinal;
    private EstadoPedido estadoDoPedido = new Recebido();
    private CarrinhoDeItens carrinho = new CarrinhoDeItens();
    private NotificadorDePedido notificador = new NotificadorDePedido();
    private String status = "recebido";
    private String itensDoPedido;

    public Pedido() {
        this.valorFinal = 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public EstadoPedido getEstadoDoPedido() {
        return estadoDoPedido;
    }

    public void setEstadoDoPedido(EstadoPedido estadoDoPedido) {
        this.estadoDoPedido = estadoDoPedido;
    }

    public void adicionarItem(Item item) {
        carrinho.adicionarItem(item);
    }

    public void removerItem(Item item) {
        carrinho.removerItem(item);
    }

    public void exibirItens() {
        carrinho.obterItens().forEach(i -> System.out.println("- " + i.getSabor()));
    }

    public String retornoItens(){
        for (Item i : carrinho.obterItens()){
            itensDoPedido = i.getSabor();
        }
        return itensDoPedido;
    }

    public double calcularValorFinal() {
        CalculadoraDeValor calculadora = new CalculadoraDeValor();
        valorFinal = calculadora.calcularValorDosItens(carrinho.obterItens());
        return valorFinal;
    }

    public void adicionarObserver(ifpb.sorveteria.Interfaces.Observer o) {
        notificador.adicionarObserver(o);
    }

    public void removerObserver(ifpb.sorveteria.Interfaces.Observer o) {
        notificador.removerObserver(o);
    }

    public void recebido() throws Exception {
        estadoDoPedido.mudarParaRecebido(this);
        notificador.notificar("Recebido.");
        status = "Recebido";
    }

    public void preparando() throws Exception {
        estadoDoPedido.mudarParaPreparando(this);
        notificador.notificar("Preparando.");
        status = "Preparando";
    }

    public void finalizado() throws Exception {
        estadoDoPedido.mudarParaFinalizado(this);
        notificador.notificar("Finalizado.");
        status = "Finalizado";
    }
}
