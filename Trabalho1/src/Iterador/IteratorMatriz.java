/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import Iterador.IteratorGrafos;

/**
 *
 * @author mortz
 */
public class IteratorMatriz extends IteratorGrafos {
    int[] linhaMatriz;
    boolean[] possuiAdjacencia;
    int colunaMatriz;
    
    public IteratorMatriz(int[] linhaMatriz,boolean[] possuiAdjacencia){
        this.linhaMatriz = linhaMatriz;
        this.possuiAdjacencia = possuiAdjacencia;
        colunaMatriz = 0;
       
        while(colunaMatriz < linhaMatriz.length && possuiAdjacencia[colunaMatriz] == false){
            colunaMatriz++;
        }
    }
    
    @Override
    public boolean hasNext() {
        if(colunaMatriz < linhaMatriz.length)return true;
        return false;
    }

    @Override
    public Integer next() {
        int retorno = colunaMatriz;
        colunaMatriz++;
        while(colunaMatriz < linhaMatriz.length && possuiAdjacencia[colunaMatriz] == false){
            colunaMatriz++;
        }
        return retorno;
    }

    @Override
    public Integer valor() {
        return linhaMatriz[colunaMatriz];
    }
    
}
