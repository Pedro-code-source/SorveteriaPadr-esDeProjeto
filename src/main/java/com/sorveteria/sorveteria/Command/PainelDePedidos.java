package com.sorveteria.sorveteria.Command;

public class PainelDePedidos {

    private Command command;

    public void definirComando(Command command) {
        this.command = command;
    }

    public void executarComando() {
        if (command != null) {
            command.executar();
        }
    }
}
