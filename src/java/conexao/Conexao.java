package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/cybermercadoweb?useSSL=false";//nome do banco
     private static final String USUARIO = "root";//nome do usuario
      private static final String SENHA = "";//senha
      ///victor
      private static final String driver = "com.mysql.cj.jdbc.Driver";//driver

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return con;
    }
  ////
}