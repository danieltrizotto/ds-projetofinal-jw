package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                e.setData_hora(rs.getDate("data_hora"));
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

    public void inserir(Pedidos p) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pedidos(fk_usuario,modo_pago,valor_total,data_hora,fk_endereço)VALUES(?,?,?,now(),?)");
            stmt.setInt(1, p.getFkUsuario());
            stmt.setString(2, p.getModo_pago());
            stmt.setFloat(3, p.getValor_total());
            stmt.setInt(4, p.getFkEndereco());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEstoque(Carrinho c) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produtos p JOIN carrinho c ON p.id_produto = c.fk_produto SET p.estoque = CASE  WHEN p.estoque >= c.quantidade THEN p.estoque - c.quantidade ELSE 0 END WHERE c.id_carrinho = ? ");
            stmt.setInt(1, c.getIdCarrinho());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void inserirPEDIDOSPROD(Carrinho c) {//para inserir na tabela pedidos produtos

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pedidos_produtos(fk_usuario,fk_produto,quantidade)VALUES(?,?,?)");
            stmt.setInt(1, c.getFkUsuario());
            stmt.setInt(2, c.getFkProduto());
            stmt.setInt(3, c.getQuantidade());

            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
            }
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCheckout(int fkUsuario) {
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
