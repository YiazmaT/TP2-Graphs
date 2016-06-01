/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaminhoMinimo;

import Iterador.IteratorGrafos;
import grafos.Grafo;
import grafos.Utilitarios;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author mortz
 */
public class Dijkstra {
    Grafo representacao;
    private int d[];
    private int pai[];
    private int Q[];
    private int numVertices;
    private int raizBusca;
    
    private static final int VISITADO = 1;
    private static final int NAO_VISITADO = 0;
    
    private PriorityQueue<HeapNode> lista;
    
    public Dijkstra(Grafo representacao){
        this.representacao = representacao;
        this.numVertices = representacao.getNumVertices();
        d = new int[numVertices];
        pai = new int[numVertices];
        lista = new PriorityQueue<HeapNode>();
        Q = new int[numVertices];
    }
    
    //Retorna uma string que mostra o caminho do vertice raiz da busca em  
    // largura até o vertice i
    //pode ser usado para pegar o caminho entra um vertice U e outro vertice V
    //bastar realizar a busca em largura com o vertice inicial U, e usar este
    //metodo com o vertice V
    //
    //************Retorna null caso não exista caminho entre os dois vertices
    //************ou caso u e v sejam iguais
    //
    //
    public String getCaminho(int i){
        return Utilitarios.getCaminho(i, pai, raizBusca);
    }
    
    public int getDistancia(int i){
        return d[i];
    }
    
    private void inicializa(int verticeInicial){
        for(int i=0;i<numVertices;i++){
            d[i] = Integer.MAX_VALUE;
            pai[i] = -1;
            Q[i] = NAO_VISITADO;
        }
        d[verticeInicial] = 0;
        lista.add(new HeapNode(0, verticeInicial));
        
    }
    
    public boolean relaxa(int u, int v, int peso){
        if(d[v] > d[u] + peso && d[u] != Integer.MAX_VALUE){
            d[v] = d[u] + peso;
            pai[v] = u;
            return true;
        }
        return false;
    }
    
    
    
    public void caminhoMinimo(int inicial){
        HeapNode nodeAtual;
        IteratorGrafos iterador;
        int nodeAdjacente,valorAresta,contador = 0;
        raizBusca = inicial;
        inicializa(inicial);
        
        while(lista.isEmpty() == false && contador < numVertices){
            nodeAtual = lista.poll();
            if(Q[nodeAtual.vertex] == NAO_VISITADO){
                contador++;
                Q[nodeAtual.vertex] = VISITADO;
            
                iterador = representacao.returnIterador(nodeAtual.vertex);
                while(iterador.hasNext()){
                    
                    valorAresta = iterador.valor();
                    nodeAdjacente = iterador.next();
                    if(relaxa(nodeAtual.vertex,nodeAdjacente , valorAresta) == true){
                        lista.add(new HeapNode(d[nodeAdjacente],nodeAdjacente));
                    }
                }
            }
        }
    }
    
    public void imprimirCaminhos(){
        Stack<Integer> pilha = new Stack<Integer>();
        int indexAtual;
        
        for(int i=0;i<numVertices;i++){
            System.out.println("No: " + i);
            System.out.println("Distancia: " + d[i]);
            System.out.print("Caminho: ");
            
            indexAtual = i;
            while(indexAtual != -1){
                pilha.add(indexAtual);
                indexAtual = pai[indexAtual];
            }
            
            indexAtual = pilha.pop();
            if(indexAtual == i){
                System.out.println("Não existe caminho para a raiz da busca");
            }else{
                System.out.print(indexAtual);
                while(pilha.empty() == false){
                    indexAtual = pilha.pop();
                    System.out.print("->" + indexAtual);
                }
                System.out.println("\n");
            }
        } 
    }
    
    private class HeapNode implements Comparable{
        private int peso;
        private int vertex;
        
        HeapNode(int peso, int vertex){
            this.peso = peso;
            this.vertex = vertex;
        }
        
        @Override
        public int compareTo(Object o) {
            HeapNode comparado = (HeapNode)o;
            
            return comparado.peso - this.peso;
        }
    }
    public int[] getPai(){
        return pai;
    }
   
}

    
