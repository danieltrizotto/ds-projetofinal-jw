/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Carrinho;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    public List<Carrinho> leitura(int id) {

        List<Carrinho> car = new ArrayList<>();
        String sql = "SELECT * FROM carrinho INNER JOIN produtos AS p ON p.id_produto = carrinho.fk_produto WHERE fk_usuario = ?  ";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho c = new Carrinho();
                c.setIdCarrinho(rs.getInt("id_carrinho"));
                c.setFkProduto(rs.getInt("fk_produto"));
                c.setFkUsuario(rs.getInt("fk_usuario"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setNome(rs.getString("nome"));
                c.setIdProduto(rs.getInt("id_produto"));
                c.setPreço(rs.getFloat("preço"));
                c.setDescriçao(rs.getString("descriçao"));
                c.setFkCategoria(rs.getInt("fk_categoria"));
                c.setImgBlob(rs.getBytes("imagem"));
                car.add(c);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return car;

    }

    public void inserir(Carrinho c) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho(fk_usuario,fk_produto,quantidade)VALUES(?,?,?)");
            stmt.setInt(1, c.getFkUsuario());
            stmt.setInt(2, c.getFkProduto());
            stmt.setInt(3, c.getQuantidade());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    ///
}
