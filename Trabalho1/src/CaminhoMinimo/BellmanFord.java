/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaminhoMinimo;

import grafos.Aresta;
import grafos.Grafo;
import grafos.Utilitarios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;


/**
 *
 * @author mortz
 */
public class BellmanFord {
    private Grafo representacao;
    private int d[];
    private int pai[];
    private int raizBusca;
   
    
    
    public BellmanFord(Grafo representacao, int numVertices){
        this.representacao = representacao;
        
        this.d = new int[numVertices];
        this.pai = new int[numVertices];
    }
    
    private void inicializa(int verticeInicial){
        for(int i=0;i<representacao.getNumVertices();i++){
            d[i] = Integer.MAX_VALUE;
            pai[i] = -1;
        }
        d[verticeInicial] = 0;
    }
    
    public void relaxa(int u, int v, int peso){
        if(d[v] > d[u] + peso && d[u] != Integer.MAX_VALUE){
            d[v] = d[u] + peso;
            pai[v] = u;
        }
    }
    
    public boolean caminhoMinimo(int raiz){
        PriorityQueue<Aresta> arestas = representacao.getArestas();
        raizBusca = raiz;
        inicializa(raiz);
        for(int i=0;i<representacao.getNumVertices()-1;i++){
            for(Aresta arestaAtual : arestas){
                relaxa(arestaAtual.getNodeA(),arestaAtual.getNodeB(),arestaAtual.getValor());
            }
        }
        for(Aresta arestaAtual : arestas){
            if(d[arestaAtual.getNodeB()] > d[arestaAtual.getNodeA()] + arestaAtual.getValor()){
                return false;
            }
        }
        return true;
    }
    
   
    public void imprimirCaminhos(){
        Stack<Integer> pilha = new Stack<Integer>();
        int indexAtual;
        
        for(int i=0;i<representacao.getNumVertices();i++){
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
}
