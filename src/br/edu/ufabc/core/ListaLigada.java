/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.core;

/**
 *
 * @author ufabc
 */
public class ListaLigada {

    /*Referencia para a primeira celula*/
    private Celula primeira;
    /*Referencia para a última célula*/
    private Celula ultima;
    /*Total de elementos na lista*/
    private int totalDeElementos;

    /*Adiciona no fim da fila*/
    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }
    
    
    public boolean existe(Object elemento) {
        if (totalDeElementos != 0) {
            Celula temp = this.primeira;
            if((Integer) elemento == (Integer) temp.getElemento()){
                return true;
            }
            
            for (int i = 0; i < totalDeElementos; i++) {
                temp = temp.getProxima();
                if (temp != null) {
                    if((Integer) elemento == (Integer) temp.getElemento()){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public void adicionaOrdenado(Object elemento){
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            if (!this.existe(elemento)) {
                Celula temp = this.primeira;
                if ((Integer) elemento < (Integer) temp.getElemento()) {
                    adicionaNoComeco(elemento);
                } else {
                    boolean inseriu = false;
                    for (int i = 0; i < totalDeElementos; i++) {
                        temp = temp.getProxima();
                        if (temp != null) {
                            if ((Integer) elemento < (Integer) temp.getElemento() && !inseriu) {

                                Celula nova = new Celula(temp, elemento);
                                Celula anterior = this.pegaCelula(i);
                                Celula proxima = temp;

                                anterior.setProxima(nova);
                                nova.setAnterior(anterior);
                                proxima.setAnterior(nova);

                                inseriu = true;
                            }
                        }
                    }
                    if (!inseriu) {
                        adiciona(elemento);
                    } else {
                        this.totalDeElementos++;
                    }
                }
            }
        }
    }
    
    
    
    /*Adiciona no inicio da fila*/
    public void adicionaNoComeco(Object elemento) {
        //Cria um celula nova
        Celula nova = new Celula(this.primeira, elemento);
        //Aponta a refencia para a celula criada
        this.primeira = nova;

        //Lista esta vazia?
        if (this.totalDeElementos == 0) {
            //Se esta vazia a ultima eh igual a primeira
            this.ultima = this.primeira;
        }
        //aumentamos o numero de elementos da lista
        this.totalDeElementos++;
    }

    /*Checa se uma dada posicao esta vazia*/
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    /*Remove do fim da lista*/
    public Object removeDoFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            return this.removeDoComeco();
        } else {
            Celula temp = this.ultima;
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
            
            return temp.getElemento();
        }
    }
    
    /*Remove do comeco*/
    public Object removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            return null;
        }
        Celula temp = this.primeira;
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
        return temp.getElemento();
    }

    /*Retorna o numero de elementos da lista*/
    public int tamanho() {
        return this.totalDeElementos;
    }
 
    /*Retorna o numero de elementos da lista*/
    public boolean isVazia() {
        return this.totalDeElementos==0;
    }
    
    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }
    
    public void printComeco(){
        if(totalDeElementos != 0){
            Celula temp = this.primeira;
            System.out.println(temp.getElemento());
          
            for(int i=0; i<totalDeElementos; i++){
                temp = temp.getProxima();
                if(temp != null){
                    System.out.println(temp.getElemento());
                }
            }
        }
    }
    
     public void printFim(){
        if(totalDeElementos != 0){
            Celula temp = this.ultima;
            System.out.println(temp.getElemento());
          
            for(int i=0; i<totalDeElementos; i++){
                temp = temp.getAnterior();
                if(temp != null){
                    System.out.println(temp.getElemento());
                }   
            }
        }
    }
     
     
    public void removePosicao(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }
    }
     
     public void remove(Integer elemento){
        
         Celula temp = this.primeira;
         if (temp != null) {
             if (elemento == (Integer) temp.getElemento()) {
                 this.removePosicao(0);
             } else {
                 for (int i = 0; i < totalDeElementos; i++) {
                     if (temp != null) {
                         if (elemento == (Integer) temp.getElemento()) {
                             this.removePosicao(i);
                         }
                     }
                     temp = temp.getProxima();
                 }
             }
         }
    }
}
