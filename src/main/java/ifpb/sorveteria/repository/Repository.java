package ifpb.sorveteria.repository;

import ifpb.sorveteria.model.Pedido;
import ifpb.sorveteria.strategy.Desconto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ifpb.sorveteria.repository.Connection.getConnection;

public class Repository {

    Desconto desconto = new Desconto();

    public Repository(){}
    public void salvarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedidos (status, desconto_aplicado, valor_total, item_do_pedido, numero_do_pedido) values (?,?,?,?,?)";

        try(java.sql.Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,pedido.getStatus());
            stmt.setDouble(2,desconto.getDesconto());
            stmt.setDouble(3,pedido.calcularValorFinal() - ((desconto.getDesconto() / 100) * pedido.calcularValorFinal()));
            stmt.setString(4,pedido.retornoItens());
            stmt.setDouble(5,pedido.getIdPedido());

            stmt.executeUpdate();
            System.out.println("Pedido salvo!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}