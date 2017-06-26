/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.les;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ufabc
 */
public class ELes {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String file = "/Users/luissantana/NetBeansProjects/e-Fila/src/br/edu/ufabc/les/input03.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            
            //tamanho da fila
            Integer tamanhoFila = Integer.parseInt(line);
            //Criamos a fila
            Les lista = new Les();
            //Lemos a sequencia de linhas
            while (line != null) {
                line = br.readLine();
                if(line != null){
                    String tipo = line.substring(0, 1);
                    if(tipo.equals("E")){
                        String itemStr = line.substring(2);
                        itemStr = itemStr.replaceAll(" ", "");
                        Integer item = Integer.parseInt(itemStr);
                        lista.remove(item);
                    }else if(tipo.equals("I")){
                        String itemStr = line.substring(2);
                        itemStr = itemStr.replaceAll(" ", "");
                        Integer item = Integer.parseInt(itemStr);
                        lista.insere(item);
                    }
                }
            }
            lista.printComeco();
        }

    }
    
}
