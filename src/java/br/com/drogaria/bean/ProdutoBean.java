/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lucio Henrique
 */
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

    private ArrayList<Produto> itens;
    private ArrayList<Produto> itensFiltrados;

    private Produto produto;

    private ArrayList<Fabricante> comboFabricante;
    private FabricanteDAO FabricanteDAO;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Fabricante> getComboFabricante() {
        return comboFabricante;
    }

    public void setComboFabricante(ArrayList<Fabricante> comboFabricante) {
        this.comboFabricante = comboFabricante;
    }

    public ArrayList<Produto> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public void carregarListagem() {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            itens = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    public void prepararNovo() {

        try {
            produto = new Produto();
            FabricanteDAO dao = new FabricanteDAO();
            comboFabricante = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());

        }

    }

    public void novo() {

        try {
            ProdutoDAO fdao = new ProdutoDAO();
            fdao.salvar(produto);

            itens = fdao.listar();

            JSFUtil.adicionarMensagemSucesso("Produto salvo com SUCESSO!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    public void excluir() {
        try {
            ProdutoDAO dao = new ProdutoDAO();

            dao.excluir(produto);

            itens = dao.listar();

            JSFUtil.adicionarMensagemSucesso("Produto Removido com SUCESSO!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }

    public void prepararEditar() {
        try {
            FabricanteDAO dao = new FabricanteDAO();

            comboFabricante = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());

        }
    }

    public void editar() {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.editar(produto);
            itens = dao.listar();
            JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }
 }

}
