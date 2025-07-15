package ifpb.sorveteria.app;

import ifpb.sorveteria.factory.*;
import ifpb.sorveteria.model.MilkShake;
import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.model.Picole;
import ifpb.sorveteria.model.Sorvete;

public class Main {
    public static void main(String[] args) throws Exception {
//        Sorvete sorvete = new SorveteFactory().criarItem("morango");
//        MilkShake milkshake = new MilkShakeFactory().criarItem("Açai");
//        Picole picole = new PicoleFactory().criarItem("pedacinho do ceu");
//        sorvete.adicionar("granulado","adicional",2);
//        milkshake.adicionar("morango","cobertura",1.5);
        Pedido pedido = new Pedido();
//        pedido.adicionarPedido(sorvete);
//        pedido.adicionarPedido(milkshake);
//        pedido.adicionarPedido(picole);
//        System.out.println(pedido.getPedidos());
//        System.out.println(pedido.getValorFinal());
//        pedido.listarPedidos();
        pedido.preparando();
        //pedido.finalizado();

        //System.out.println(pedido.getEstadoDoPedido());
    }
}
