/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.les;

import br.edu.ufabc.core.ListaLigada;

/**
 *
 * @author luissantana
 */
public class Les {
    
    private ListaLigada objetos;

    public Les(){
        this.objetos = new ListaLigada();
    }
    
    public void insere(Object obj) {
        this.objetos.adicionaOrdenado(obj);
    }

    public void remove(Integer elemento) {
        this.objetos.remove(elemento);
    }

    public boolean vazia() {
        return this.objetos.isVazia();
    }
    
    public void printComeco(){
        objetos.printComeco();
    } 
}
