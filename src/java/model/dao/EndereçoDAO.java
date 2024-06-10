/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Endereço;

/**
 *
 * @author Senai
 */
public class EndereçoDAO {

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
