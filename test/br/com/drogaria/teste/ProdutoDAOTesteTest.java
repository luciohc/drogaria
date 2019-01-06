/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucio Henrique
 */
public class ProdutoDAOTesteTest {
    
    public ProdutoDAOTesteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class ProdutoDAOTeste.
     */
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        ProdutoDAOTeste instance = new ProdutoDAOTeste();
        instance.salvar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
