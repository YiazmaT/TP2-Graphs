/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import Iterador.IteratorGrafos;
import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 *
 * @author mortz
 */
public abstract class Grafo{
    protected int numVertices;
    protected boolean orientado;

    
    
    public boolean isOrientado() {
        return orientado;
    }

    public void setOrientado(boolean orientado) {
        this.orientado = orientado;
    }
    
    public void setNumVertices(int numVertices){
        this.numVertices = numVertices;
    }
    
    public int getNumVertices(){
        return numVertices;
    }
   
    public abstract IteratorGrafos returnIterador(int vertice);
    public abstract boolean inserirAdjacencia(int nodeA, int nodeB,int valor);
    public abstract boolean isAdjacente(int nodeA, int nodeB);
    public abstract void imprimir();
    public abstract PriorityQueue<Aresta> getArestas();
    public abstract int getPesoAresta(int nodeA, int nodeB);
    
    
    //Retorna um texto que contem as informações do grafo
    //O texto retornado possui o mesmo padrão do texto usado para carregar
    //os grafos no programa
    public String getTextoGrafo() {
        String grafoText = new String("");
        
        //A arvore gerada é um grafo
        grafoText = grafoText.concat("Tipo: Grafo\n");
        grafoText = grafoText.concat("Número de vértices: " + String.valueOf(this.getNumVertices()) + "\n\n");
        
        IteratorGrafos iterador;
        int verticeAdjacente, valorAresta;
        
        for(int i=0;i<numVertices;i++){
            iterador = this.returnIterador(i);
            while(iterador.hasNext()){
                valorAresta = iterador.valor();
                verticeAdjacente = iterador.next();
            
                if(i < verticeAdjacente || this.orientado == true){
                    grafoText = grafoText.concat("Vértices: " + i + " e " + verticeAdjacente + " - Peso: " + valorAresta + "\n");
                }
            }
        }
        
        return grafoText;
    }
    
}
