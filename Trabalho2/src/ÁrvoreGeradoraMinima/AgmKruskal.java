/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ÁrvoreGeradoraMinima;

import grafos.Aresta;
import grafos.Grafo;
import grafos.ListaAdjacencia;
import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 *
 * @author mortz
 */
public class AgmKruskal {
    private Grafo grafo;
    private int numVertice;
    private int[] conjuntos;
    private PriorityQueue<Aresta> arestas;
    
    
    public AgmKruskal(int numVertice, Grafo grafo){
        this.grafo = grafo;
        this.numVertice = numVertice;
        conjuntos = new int[numVertice];
    }
    
    //O(n)
    public void criarConjuntos(){
        for(int i=0;i<numVertice;i++){
            conjuntos[i] = i;
        }
    }
    
    //O(1)
    public boolean mesmoConjunto(int nodeA, int nodeB){
        return conjuntos[nodeA] == conjuntos[nodeB];
    }
    
    //O(n)
    public void unirConjuntos(int nodeA, int nodeB){
        int conjuntoB = conjuntos[nodeB];
        int conjuntoA = conjuntos[nodeA];
        
        for(int i=0;i<numVertice;i++){
            if(conjuntos[i] == conjuntoB){
                conjuntos[i] = conjuntoA;
            }
        }
    }
    
    
    //Retorna um grafo representado por uma lista de adjacencia
    public Grafo AGM(){
        Aresta arestaAtual;
        Grafo arvoreGeradora = new ListaAdjacencia(numVertice,false);
        arestas = grafo.getArestas();
        criarConjuntos();
        
        while(!arestas.isEmpty()){
            arestaAtual = arestas.remove();
            if(!mesmoConjunto(arestaAtual.getNodeA(),arestaAtual.getNodeB())){
                
                arvoreGeradora.inserirAdjacencia(arestaAtual.getNodeA(),
                                                 arestaAtual.getNodeB(),
                                                 arestaAtual.getValor());
                
                unirConjuntos(arestaAtual.getNodeA(),arestaAtual.getNodeB());
            }
            
        }
        return arvoreGeradora;
    }
}
