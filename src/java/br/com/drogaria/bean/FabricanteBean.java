/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lucio Henrique
 */
@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

    private Fabricante fabricante; // Variável que vai guardar os dados que quer salvar no banco de dados(gravar, excluir e editar)    

    private ArrayList<Fabricante> itens; // Variável é responsável por exibir os dados na tela
    private ArrayList<Fabricante> itensFiltrados;

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public ArrayList<Fabricante> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Fabricante> itens) {
        this.itens = itens;
    }

    public ArrayList<Fabricante> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    

    @PostConstruct //  metodo vai ser chamado antes da tela ser renderizada      
    public void prepararPesquisa() {

        try {
            FabricanteDAO dao = new FabricanteDAO();
            itens = dao.listar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    public void prepararNovo() {
        fabricante = new Fabricante();

    }

    public void novo() {

        try {
            FabricanteDAO fdao = new FabricanteDAO();
            fdao.salvar(fabricante);

            itens = fdao.listar();
            

            JSFUtil.adicionarMensagemSucesso("Fabricante salvo com SUCESSO!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    

    public void excluir() {
        try {
            FabricanteDAO dao = new FabricanteDAO();
            dao.excluir(fabricante);

            itens = dao.listar();           

            JSFUtil.adicionarMensagemSucesso("Fabricante Removido com SUCESSO!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    
    public void editar() {
        try {
            FabricanteDAO dao = new FabricanteDAO();
            dao.editar(fabricante);

            ArrayList<Fabricante> lista;

            itens= dao.listar();
            
            
            JSFUtil.adicionarMensagemSucesso("Fabricante Editado com Sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
            
        }

    }

}
