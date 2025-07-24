package ifpb.sorveteria.observer;

import ifpb.sorveteria.Interfaces.Observer;

public class NotificadorConsole implements Observer {

    @Override
    public void atualizar(String mensagem) {
        System.out.println("📢 Notificação do Pedido: " + mensagem);
    }
}
