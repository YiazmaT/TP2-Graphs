/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreGeradoraMinima;

import grafos.Grafo;
import Iterador.IteratorGrafos;
import grafos.ListaAdjacencia;

/**
 *
 * @author mortz
 */
public class AgmPrim {
    private int[] Q;
    private int[] chave;
    private int[] pai;
    private Grafo grafo;
    private int numVertice;
    
    private static final int PERTENCE = 1;
    private static final int NAOPERTENCE = 0;
    
    public AgmPrim(int numVertice,Grafo grafo){
        this.numVertice = numVertice;
        this.grafo = grafo;
        
        Q = new int[numVertice];
        chave = new int[numVertice];
        pai = new int[numVertice];
    }

   
    //O(n)
    public boolean Qvazio(){
        for(int i=0;i<numVertice;i++){
            if(Q[i] == PERTENCE)return false;
        }
        return true;
    }
    
    //O(n)
    public int minimoQ(){
        int minimo=0,i,posiMinimo = 0;
        
        for(i=0;i<numVertice;i++){
            if(pertenceQ(i)){
                minimo = chave[i];
                posiMinimo = i;
                break;
            }
        }
        for(;i<numVertice;i++){
            if(chave[i] < minimo && pertenceQ(i)){
                minimo = chave[i];
                posiMinimo = i;
            }
        }
        Q[posiMinimo] = NAOPERTENCE;
        return posiMinimo;
    }
       
    
    //O(1)
    public boolean pertenceQ(int vertice){
        if(Q[vertice] == PERTENCE)return true;
        return false;
    }
    
    //Retorna um grafo representado por lista de adjacencia
    public Grafo AGM(){
        
        Grafo arvoreGeradora = new ListaAdjacencia(numVertice,false);
        IteratorGrafos iterador;
        int verticeAtual,adjacente,valorAresta;
        
        for(int i=0;i<numVertice;i++){
            pai[i] = -1;
            Q[i] = PERTENCE;
            chave[i] = Integer.MAX_VALUE;
        }
        chave[0] = 0;
        
        while(!Qvazio()){
            verticeAtual = minimoQ();
            arvoreGeradora.inserirAdjacencia(verticeAtual, pai[verticeAtual],chave[verticeAtual]);
            
            iterador = grafo.returnIterador(verticeAtual);
            
            while(iterador.hasNext()){
                valorAresta = iterador.valor();
                adjacente = iterador.next();
                
                if(pertenceQ(adjacente) && valorAresta < chave[adjacente]){
                    pai[adjacente] = verticeAtual;
                    chave[adjacente] = valorAresta;
                }
            }
        }
        
        return arvoreGeradora;
    }
    
}
