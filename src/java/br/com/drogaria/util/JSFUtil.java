/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Autor: Lúcio Henrique da Costa
 */
package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucio Henrique
 */
public class JSFUtil {
    
    public static void adicionarMensagemSucesso(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem, mensagem);
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    
    public static void adicionarMensagemErro(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem, mensagem);
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    
}
