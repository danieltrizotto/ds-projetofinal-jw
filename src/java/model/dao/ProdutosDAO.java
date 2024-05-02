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
                byte[] imageBytes = rs.getBytes("imagem");
                objProduto.setPreço(rs.getFloat("preço"));
                String base64Image = convertToBase64(imageBytes);
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
    
     public void insertProduto(Produtos objProduto) {
        //victor
        String sql = "INSERT INTO produtos(fk_categoria,nome,descriçao,imagem,preço)values(?,?,?,?,?)";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement(sql); 
            stmt.setInt(1, objProduto.getFk_categoria());
            stmt.setString(2, objProduto.getNome());
            stmt.setString(3, objProduto.getDescriçao());
            stmt.setBytes(4, objProduto.getImgBlob());
            stmt.setFloat(5, objProduto.getPreço());
           
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(" cadastro de produto: " + e);
        }
        ////
    }
}
