/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucio Henrique
 */
public class FabricanteDAO {

    public void salvar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FABRICANTE ");
        sql.append("(descricao)");
        sql.append("VALUES(?)");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());

        comando.executeUpdate();
    }

    public void excluir(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM FABRICANTE ");
        sql.append("WHERE CODIGO = ? ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());

        comando.executeUpdate();

    }

    public void editar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE FABRICANTE ");
        sql.append("SET DESCRICAO = ? ");
        sql.append("WHERE CODIGO = ? ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.setLong(2, f.getCodigo());

        comando.executeUpdate();

    }

    public Fabricante buscarporCodigo(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, DESCRICAO ");
        sql.append("FROM FABRICANTE ");
        sql.append("WHERE CODIGO = ? ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());

        ResultSet resultado = comando.executeQuery();

        Fabricante retorno = null;

        if (resultado.next()) {
            retorno = new Fabricante();
            retorno.setCodigo((int) resultado.getLong("codigo"));
            retorno.setDescricao(resultado.getString("descricao"));

        }
        return retorno;
    }

    public ArrayList<Fabricante> listar() throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, DESCRICAO ");
        sql.append("FROM FABRICANTE ");
        sql.append("ORDER BY DESCRICAO ASC ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());

        ResultSet resultado = comando.executeQuery();

        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

        while (resultado.next()) {
            Fabricante f = new Fabricante();
            f.setCodigo(resultado.getLong("codigo"));
            f.setDescricao(resultado.getString("descricao"));

            lista.add(f);

        }

        return lista;

    }

    
    public ArrayList<Fabricante>  buscarPorDescricao(Fabricante f) throws SQLException {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, DESCRICAO ");
        sql.append("FROM FABRICANTE ");
        sql.append("WHERE DESCRICAO LIKE ? ");        
        sql.append("ORDER BY DESCRICAO ASC ");
        
        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setString(1, "%" + f.getDescricao() + "%"  );
        
        ResultSet resultado = comando.executeQuery();

        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

        while (resultado.next()) {
            Fabricante item = new Fabricante();
            f.setCodigo(resultado.getLong("codigo"));
            f.setDescricao(resultado.getString("descricao"));

            lista.add(f);

        }

        return lista;   
   
    }
       
    
    public static void main(String[] args) {
        /*Fabricante f1 = new Fabricante();
            f1.setDescricao("DESCRICAO 1");
            Fabricante f2 = new Fabricante();
            f2.setDescricao("DESCRICAO 2");
            
           FabricanteDAO fdao = new FabricanteDAO();
            
           try {
               fdao.salvar(f1);
               fdao.salvar(f2);
               System.out.println("Os fabricantes foram salvos com sucesso");
           } catch (SQLException ex) {
               System.out.println("Ocorreu um erro ao tentar salvar um dos fabricantes");
               ex.printStackTrace();
           }*/

 /* Fabricante f1 = new Fabricante();
            f1.setCodigo(2);
            Fabricante f2 = new Fabricante();
            f2.setCodigo(5);
            
            FabricanteDAO fdao = new FabricanteDAO();
           try {
               fdao.excluir(f1);
               fdao.excluir(f2);
               System.out.println("Os fabricantes foram excluidos com sucesso");
           } catch (SQLException ex) {
               System.out.println("Ocorreu um erro ao tentar excluir um dos fabricantes!");
               ex.printStackTrace();
           }*/
 /* Fabricante f1 = new Fabricante();
           f1.setCodigo(3);
           f1.setDescricao("DESCRICAO 3");
           
           FabricanteDAO fdao = new FabricanteDAO();
           try {
               fdao.editar(f1);
               System.out.println("O Fabricante foi atualizado com sucesso");
           } catch (SQLException ex) {
               System.out.println("Ocorreu um erro ao tentar atualizar o fabricante");
               ex.printStackTrace();
           }*/
 /*Fabricante f1 = new Fabricante();
           f1.setCodigo(3);
           
           Fabricante f2 = new Fabricante();
           f1.setCodigo(5);
           
           FabricanteDAO fdao = new FabricanteDAO();
           
           try {
               Fabricante f3 = fdao.buscarporCodigo(f1);
               Fabricante f4 = fdao.buscarporCodigo(f2);   
               
               System.out.println("Resultado 1: " + f3);
               System.out.println("Resultado 2: " + f4);
               
           } catch (SQLException ex) {
               System.out.println("Ocorreu um erro ao tentar pesquisar um dos fabricantes!");
               ex.printStackTrace();
           }*/
        /*FabricanteDAO fdao = new FabricanteDAO();
        try {
            ArrayList<Fabricante> lista = fdao.listar();
            
            for (Fabricante f : lista){
                System.out.println("Resultado: " + f);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar listar os fabricantes!");
            ex.printStackTrace();
        }*/
        
        Fabricante f1 = new Fabricante();
        f1.setDescricao(2);
        
        FabricanteDAO fdao = new FabricanteDAO();
                
        try {
           ArrayList<Fabricante>  lista = fdao.buscarPorDescricao(f1);
           
           for (Fabricante f : lista){
                System.out.println("Resultado: " + f);
            }
        } catch (SQLException ex) {
            System.out.println("ocorreu um erro ao tentar pesquisar um fabricante");
            ex.printStackTrace();
        }
 
    }
}
