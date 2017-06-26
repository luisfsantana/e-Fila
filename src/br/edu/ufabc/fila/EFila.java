/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.fila;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ufabc
 */
public class EFila {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String file = "/Users/luissantana/NetBeansProjects/e-Fila/src/br/edu/ufabc/fila/input01.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            
            //tamanho da fila
            Integer tamanhoFila = Integer.parseInt(line);
            //Criamos a fila
            Fila fila = new Fila(tamanhoFila);
            //Lemos a sequencia de linhas
            while (line != null) {
                line = br.readLine();
                if(line != null){
                    String tipo = line.substring(0, 1);
                    if(tipo.equals("D")){
                        Integer num = fila.remove();
                        System.out.println(num);
                    }else if(tipo.equals("E")){
                        String itemStr = line.substring(2);
                        Integer item = Integer.parseInt(itemStr);
                        fila.insere(item);
                    }
                }
            }
        }

    }
    
}
