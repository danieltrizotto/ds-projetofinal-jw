package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Carrinho;
import model.bean.Pedidos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Senai
 */
public class PedidosDAO {

    public List<Pedidos> leitura(int id) {//le os pedidos para mostrar na pagina de pedidos

        List<Pedidos> p = new ArrayList<>();
        String sql = "SELECT * FROM pedidos INNER JOIN produtos AS p ON p.id_produto = pedido.fk_produtos WHERE fk_usuario = ?  ";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedidos e = new Pedidos();
                e.setIdPedido(rs.getInt("id_pedido"));
                e.setFkEndereco(rs.getInt("fk_endereço"));
                e.setFkUsuario(rs.getInt("fk_usuario"));
                e.setFkEndereco(rs.getInt("fk_endereço"));
                e.setModo_pago(rs.getString("modo_pago"));
                e.setPagamento(rs.getString("pagamento"));
                e.setValor_total(rs.getFloat("valor_total"));

                p.add(e);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return p;

    }

    public int inserirPedidos(Pedidos p) {
        int lastId = -1;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(
                    "INSERT INTO pedidos(fk_usuario, modo_pago, valor_total, data_hora, fk_endereço) VALUES (?, ?, ?, now(), ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setInt(1, p.getFkUsuario());
            stmt.setString(2, p.getModo_pago());
            stmt.setFloat(3, p.getValor_total());
            stmt.setInt(4, p.getFkEndereco());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }

    public void updateEstoque(int qtd, int id) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produtos SET estoque =( estoque - ?) WHERE id_produto = ?");
            stmt.setInt(1, qtd);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

  public void inserirPEDIDOSPROD(int qtd,int fk, int pedidoId) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO pedidos_produtos(pedido_fk,produto_fk, quantidade) VALUES (?, ?, ?)");
        stmt.setInt(1, pedidoId);
        stmt.setInt(2, fk);
        stmt.setInt(3, qtd);
       
        stmt.executeUpdate();

        stmt.close();
        conexao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void deleteCarrinho(int fkUsuario) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinho where fk_usuario = ?");
            stmt.setInt(1, fkUsuario);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
