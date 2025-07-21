package ifpb.sorveteria.Interfaces;

import ifpb.sorveteria.model.Pedido;

public interface Command {
    void fazer(Pedido pedido) throws Exception;
    void desfazer(Pedido pedido) throws Exception;
}
