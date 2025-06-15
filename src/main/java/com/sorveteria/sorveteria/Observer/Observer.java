package com.sorveteria.sorveteria.Observer;

import com.sorveteria.sorveteria.model.StatusPedido;

public interface Observer {
    void atualizar(StatusPedido status);
}
