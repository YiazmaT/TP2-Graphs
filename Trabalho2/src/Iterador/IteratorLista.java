/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import Iterador.IteratorGrafos;
import grafos.NodeLista;

/**
 *
 * @author mortz
 */
public class IteratorLista extends IteratorGrafos{
    NodeLista listaAdjacencia;
    
    public IteratorLista(NodeLista listaAdjacencia){
        this.listaAdjacencia = listaAdjacencia;
    }
    
    @Override
    public boolean hasNext() {
        return listaAdjacencia != null;
    }

    @Override
    public Integer next() {
        int retorno = listaAdjacencia.getNumVertice();
        listaAdjacencia = listaAdjacencia.getProx();
        return retorno;
    }
    
    public Integer valor(){
        return listaAdjacencia.getValorAresta();
    }
    
}
