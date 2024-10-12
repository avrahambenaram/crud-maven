package com.da.crudmaven.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.da.crudmaven.util.Conexao;

public class UsuarioDAO {

    public boolean autenticar(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM usuarios WHERE username = ? AND password = ?");
        comando.setString(1, username);
        comando.setString(2, password);
        ResultSet resultado = comando.executeQuery();
        boolean autenticado = resultado.next();
        con.close();
        return autenticado;
    }
}
