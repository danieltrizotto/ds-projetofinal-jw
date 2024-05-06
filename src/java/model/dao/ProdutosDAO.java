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
import java.util.Base64;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class ProdutosDAO {

    public List<Produtos> leitura() {
        ////victor
        List<Produtos> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos objProduto = new Produtos();
                objProduto.setId_Produto(rs.getInt("id_produto"));
                objProduto.setFk_categoria(rs.getInt("fk_categoria"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setDescriçao("descriçao");
                objProduto.setImgBlob(rs.getBytes("imagem"));
                objProduto.setPreço(rs.getFloat("preço"));
                produtos.add(objProduto);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return produtos;

    }

    public List<Produtos> buscaProdutos(String busca) {
        List<Produtos> resultBusca = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descriçao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos objProduto = new Produtos();
                objProduto.setId_Produto(rs.getInt("id_produto"));
                objProduto.setFk_categoria(rs.getInt("fk_categoria"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setDescriçao("descriçao");
                objProduto.setImgBlob(rs.getBytes("imagem"));
                objProduto.setPreço(rs.getFloat("preço"));

                resultBusca.add(objProduto);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }

        return resultBusca;

    }

    public List<Produtos> buscaCategorias(int categoria) {
        List<Produtos> resultBusca = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE fk_categoria = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produtos prod = new Produtos();
                prod.setId_Produto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setFk_categoria(rs.getInt("fk_categoria"));
                prod.setDescriçao(rs.getString("descriçao"));
                prod.setPreço(rs.getFloat("preço"));
                prod.setImgBlob(rs.getBytes("imagem"));
                
                resultBusca.add(prod);
            }

        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }

        return resultBusca;

    }

    public void insertProduto(Produtos p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO produtos (fk_categoria, nome, preço, descriçao, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getFk_categoria());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getPreço());
            stmt.setString(4, p.getDescriçao());
            stmt.setBytes(5, p.getImgBlob());
            System.out.println("feito");
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
