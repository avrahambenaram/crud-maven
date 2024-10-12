/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.da.crudmaven.dao;

/**
 *
 * @author Beyonder
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.da.crudmaven.model.Falecido;
import com.da.crudmaven.util.Conexao;

public class FalecidoDAO {

    public void cadastrar(Falecido f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("INSERT INTO falecido (nome, cpf, nascimento, morte, nacionalidade, peso, altura, convenio, salaVelorio, doacao, cremacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        comando.setString(1, f.getNome());
        comando.setString(2, f.getCpf());
        comando.setDate(3, new java.sql.Date(f.getNascimento().getTime()));
        comando.setDate(4, new java.sql.Date(f.getMorte().getTime()));
        comando.setString(5, f.getNacionalidade());
        comando.setFloat(6, f.getPeso());
        comando.setFloat(7, f.getAltura());
        comando.setString(8, f.getConvenio());
        comando.setString(9, f.getSalaVelorio());
        comando.setBoolean(10, f.getDoacaoOrgaos());
        comando.setBoolean(11, f.getCremacao());
        comando.execute();
        con.close();
    }
    
    public void deletar(Falecido f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("DELETE FROM falecido WHERE id = ?");
        comando.setInt(1, f.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Falecido f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE falecido SET nome = ?, cpf = ?, nascimento = ?, morte = ?, nacionalidade = ?, peso = ?, altura = ?, convenio = ?, salaVelorio = ?, doacao = ?, cremacao = ? WHERE id = ?");
        comando.setString(1, f.getNome());
        comando.setString(2, f.getCpf());
        comando.setDate(3, new java.sql.Date(f.getNascimento().getTime()));
        comando.setDate(4, new java.sql.Date(f.getMorte().getTime()));
        comando.setString(5, f.getNacionalidade());
        comando.setFloat(6, f.getPeso());
        comando.setFloat(7, f.getAltura());
        comando.setString(8, f.getConvenio());
        comando.setString(9, f.getSalaVelorio());
        comando.setBoolean(10, f.getDoacaoOrgaos());
        comando.setBoolean(11, f.getCremacao());
        comando.setInt(12, f.getId());
        comando.execute();
        con.close();
    }

    public Falecido consultarById(Falecido falecido) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM falecido WHERE id = ?");
        comando.setInt(1, falecido.getId());
        ResultSet resultado = comando.executeQuery();
        
        Falecido f = null;
        if (resultado.next()) {
            f = new Falecido(
                resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("cpf"),
                resultado.getDate("nascimento"),
                resultado.getDate("morte"),
                resultado.getString("nacionalidade"),
                resultado.getFloat("peso"),
                resultado.getFloat("altura"),
                resultado.getString("convenio"),
                resultado.getString("salaVelorio"),
                resultado.getBoolean("doacao"),
                resultado.getBoolean("cremacao")
            );
        }
        con.close();
        return f;
    }

    public List<Falecido> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM falecido");
        ResultSet resultado = comando.executeQuery();
        List<Falecido> todosFalecidos = new ArrayList<>();
        
        while (resultado.next()) {
            Falecido f = new Falecido(
                resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("cpfFalecido"),
                resultado.getDate("nascimento"),
                resultado.getDate("morte"),
                resultado.getString("nacionalidade"),
                resultado.getFloat("pesoFalecido"),
                resultado.getFloat("altura"),
                resultado.getString("convenio"),
                resultado.getString("salaVelorio"),
                resultado.getBoolean("doacao"),
                resultado.getBoolean("cremacao")
            );
            todosFalecidos.add(f);
        }
        con.close();
        return todosFalecidos;
    }
}
