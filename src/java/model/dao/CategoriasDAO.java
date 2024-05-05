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
import model.bean.Produtos;
import model.bean.Categorias;

/**
 *
 * @author User
 */
public class CategoriasDAO {
  public List<Categorias> listarCategorias() {
        List<Categorias> categorias = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Categorias categoriaAtual = new Categorias();
                categoriaAtual.setIdCategoria(rs.getInt("id_categoria"));
                categoriaAtual.setNome(rs.getString("nome"));
                
                categorias.add(categoriaAtual);
            }
        } catch(SQLException e) {
            
        }
        
        return categorias;
    }
}
