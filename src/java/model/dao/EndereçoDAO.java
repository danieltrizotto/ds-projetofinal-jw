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
import model.bean.Endereço;

/**
 *
 * @author Senai
 */
public class EndereçoDAO {

    public List<Endereço> leitura(int id) {
       
        List<Endereço> locais = new ArrayList<>();
        String sql = "SELECT * FROM enderecos WHERE fk_usuario = ?";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
             stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereço e = new Endereço();
                e.setId_endereco(rs.getInt("id_endereco"));
                e.setFk_usuario(rs.getInt("fk_usuario"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getInt("numero"));
                e.setCep(rs.getString("cep"));
                locais.add(e);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return locais;

    }

    public void inserirEndereço(Endereço e) {//insert de endereço
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("insert into enderecos (fk_usuario,rua,cep,numero) values (?,?,?,?)");
            stmt.setInt(1, e.getFk_usuario());
            stmt.setString(2, e.getRua());
            stmt.setString(3, e.getCep());
            stmt.setInt(4, e.getNumero());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}
