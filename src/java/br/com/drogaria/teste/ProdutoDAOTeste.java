/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Lucio Henrique
 */
public class ProdutoDAOTeste {
    @Test
    @Ignore
    public void salvar() throws SQLException{
        Produto p = new Produto();
        p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
        p.setPreco(2.45);
        p.setQuantidade(13L);
        
       Fabricante f = new Fabricante();
       f.setCodigo((int) 49L);
       
       p.setFabricante(f);
       
       ProdutoDAO dao = new ProdutoDAO();
       dao.salvar(p);
  }
    
    @Test
    @Ignore
    public void listar() throws SQLException{
        ProdutoDAO dao = new ProdutoDAO();
        
        ArrayList<Produto> lista = dao.listar();
        
        for(Produto p : lista){
            System.out.println("Código do Produto: " + p.getCodigo());
            System.out.println("Descrição do Produto " + p.getDescricao());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Código do Fabricante: " + p.getFabricante().getCodigo());
            System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
            System.out.println();                     
            
        }
    }
    
    @Test
    @Ignore
    public void excluir() throws SQLException{
        Produto p = new Produto();
        p.setCodigo(6L);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.excluir(p);      
        

        
    }
    
    @Test
    public void editar() throws SQLException{
        Produto p = new Produto();
        p.setDescricao("CATAFLAN POMADA COM 60 GRAMAS");
        p.setPreco(15.45);
        p.setQuantidade(13L);
        
       Fabricante f = new Fabricante();
       f.setCodigo((int) 49L);
       
       p.setFabricante(f);
       
       ProdutoDAO dao = new ProdutoDAO();
       dao.editar(p);
  }
    
    
    
}
