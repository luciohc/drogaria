/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.factory;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucio Henrique
 */
public class ConexaoFactory {
    
    private static final String USUARIO = "root";
    private static final String SENHA = "novaera2018";
    private static final String URL = "jdbc:mysql://localhost:33060/drogaria";
    
    public static Connection conectar() throws SQLException{
        Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;      
           
    }
    
    public static void main (String[] args) {
        try{
           Connection conexao = ConexaoFactory.conectar();
           System.out.println("Conexão realizada com sucesso");
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Não foi possível realizar a conexão");
        }
    }      
    }  
