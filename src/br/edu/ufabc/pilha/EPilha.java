/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.pilha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author luissantana
 */
public class EPilha {
 
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String file = "/Users/luissantana/NetBeansProjects/e-Fila/src/br/edu/ufabc/pilha/input02.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            
            //tamanho da fila
            Integer tamanhoPilha = Integer.parseInt(line);
            //Criamos a fila
            Pilha pilha = new Pilha(tamanhoPilha);
            //Lemos a sequencia de linhas
            while (line != null) {
                line = br.readLine();
                if(line != null){
                    String tipo = line.substring(0, 1);
                    switch (tipo) {
                        case "D":
                            pilha.remove();
                            //System.out.println(num);
                            break;
                        case "E":
                            String itemStr = line.substring(2);
                            Integer item = Integer.parseInt(itemStr);
                            pilha.insere(item);
                            break;
                        case "T":
                            pilha.printFim();
                            break;
                        case "B":
                            pilha.printComeco();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
