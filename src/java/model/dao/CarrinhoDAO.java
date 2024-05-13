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

    public List<Carrinho> leitura() {
        List<Carrinho> car = new ArrayList<>();
     String sql = "SELECT * FROM carrinho INNER JOIN produtos ON carrinho.fkProduto = produtos.id_produto";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho c = new Carrinho();
                c.setIdCarrinho(rs.getInt("idCarrinho"));
                c.setFkProduto(rs.getInt("fkProduto"));
                c.setFkUsuario(rs.getInt("fkUsuario"));
                c.setNome(rs.getString("nomeProduto"));
                c.setPreçoUnitario(rs.getFloat("preçoUnitario"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setImgBlob(rs.getBytes("imgBlob"));
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

            stmt = conexao.prepareStatement("INSERT INTO carrinho(fkUsuario,fkProduto,nome,quantidade,preçoUnitario,imgBlob)VALUES(?,?,?,?,?,?)");
          stmt.setInt(1, c.getFkUsuario());
          stmt.setInt(2, c.getFkProduto());
          stmt.setString(3, c.getNome());
          stmt.setInt(4, c.getQuantidade());
          stmt.setFloat(5, c.getPreçoUnitario());
          stmt.setBytes(6, c.getImgBlob());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
