/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.fila;

import br.edu.ufabc.core.ListaLigada;

/**
 *
 * @author ufabc
 */
public class Fila {
    
    private ListaLigada objetos = new ListaLigada();
    private int numElementos;

    public Fila(int numElementos){
        this.numElementos = numElementos;
    }
    
    public void insere(Object obj) {
        if( objetos.tamanho() < numElementos){
            this.objetos.adiciona(obj);
        }
    }

    public Integer remove() {
        return (Integer) this.objetos.removeDoComeco();
    }

    public boolean vazia() {
        return this.objetos.isVazia();
    }
    
    public void setNumElementos(int numElementos){
        this.numElementos = numElementos;
    }
    
    public int getNumElementos(){
        return this.numElementos;
    }
}


