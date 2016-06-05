/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import Iterador.IteratorMatriz;
import Iterador.IteratorGrafos;
import ÁrvoreGeradoraMinima.AgmKruskal;
import ÁrvoreGeradoraMinima.AgmPrim;
import grafos.Grafo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


/**
 *
 * @author mortz
 */
public class MatrizAdjacencia extends Grafo {
    private int matriz[][];
    
    //Criada para permitir que arestas com peso 0 tambem sejam consideradas
    //na matriz
    private boolean possuiAdjacencia[][];
          
            
    public MatrizAdjacencia(int numVertices,boolean orientado){
        setNumVertices(numVertices);
        this.orientado = orientado;
        
        possuiAdjacencia = new boolean[numVertices][numVertices];
        matriz = new int[numVertices][numVertices];
    }
    
    public boolean inserirAdjacencia(int nodeA, int nodeB,int valor){
        if(nodeA > numVertices || nodeB > numVertices || nodeA < 0 || nodeB < 0){
            return false;
        }
        matriz[nodeA][nodeB] = valor;
        possuiAdjacencia[nodeA][nodeB] = true;
        if(!orientado){
            matriz[nodeB][nodeA] = valor;
            possuiAdjacencia[nodeB][nodeA] = true;
        }
        
        return true;
    }
    
    public boolean removerAdjacencia(int nodeA, int nodeB){
        if(nodeA > numVertices || nodeB > numVertices){
            return false;
        }
        matriz[nodeA][nodeB] = 0;
        possuiAdjacencia[nodeA][nodeB] = false;
        if(!orientado){
            matriz[nodeB][nodeA] = 0;
            possuiAdjacencia[nodeA][nodeB] = false;
        }
        return true;
    }
    
    public boolean isAdjacente(int nodeA, int nodeB){
        return possuiAdjacencia[nodeA][nodeB] == true; 
    }
    
    public void imprimir(){
        System.out.print("    ");
        for(int i=0;i<this.numVertices;i++){
            System.out.print(i + " ");
        }
        System.out.println("");
        
        System.out.print("   ");
        for(int i=0;i<this.numVertices;i++){
            System.out.print("--");
        }
        System.out.println("");
        
        for(int i=0;i<this.numVertices;i++){
            System.out.print(i + " | ");
            for(int j=0;j<this.numVertices;j++){
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    
    @Override
    public IteratorGrafos returnIterador(int vertice) {
        return new IteratorMatriz(matriz[vertice],possuiAdjacencia[vertice]);
    }

   
    @Override
    public PriorityQueue<Aresta> getArestas() {
       PriorityQueue<Aresta> arestas = new PriorityQueue<Aresta>();
       int j; 
       for(int i=0;i<numVertices;i++){
          
           for(j=0;j<numVertices;j++){
                if(possuiAdjacencia[i][j] == true){
                    arestas.add(new Aresta(i,j,this.matriz[i][j]));
                }
            }
        }
        return arestas;
    }

    @Override
    public int getPesoAresta(int nodeA, int nodeB) {
        return matriz[nodeA][nodeB];
    }
    
    
    
}
