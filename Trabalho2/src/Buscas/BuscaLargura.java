/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscas;

import grafos.Grafo;
import Iterador.IteratorGrafos;
import grafos.Utilitarios;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author mortz
 */
public class BuscaLargura {
    private Grafo representacao;
    private int cor[];
    private int pai[];
    private int distancia[];
    private int raizBusca;
    
    private final static int BRANCO = 1;
    private final static int CINZA = 2;
    private final static int PRETO = 3;
           
    public BuscaLargura(Grafo representacao){
        
        pai = new int[representacao.getNumVertices()];
        distancia = new int[representacao.getNumVertices()];
        cor = new int[representacao.getNumVertices()];
        this.representacao = representacao;
    }
   
    //Retorna o vetor de distancias do vertice raiz para os outros vertice
    //O vertice raiz possui distancia -1
    public int getDistancia(int i){
        return distancia[i];
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
    public String getCaminho(int i){
        return Utilitarios.getCaminho(i, pai, raizBusca);
    }
    
    public void buscaLargura(int verticeRaiz){
        int i,verticeAtual;
        raizBusca = verticeRaiz;
        Queue<Integer> fila = new LinkedList<Integer>();
        IteratorGrafos iteradorGrafo;
        for(i=0;i<representacao.getNumVertices();i++){
            cor[i] = BRANCO;
            distancia[i] = -1;
            pai[i] = -1;
        }
        
        cor[verticeRaiz] = CINZA;
        distancia[verticeRaiz] = 0;
        pai[verticeRaiz] = -1;
        fila.add(verticeRaiz);
        
        while(fila.isEmpty() == false)
       {
            verticeAtual = fila.remove();
            iteradorGrafo = representacao.returnIterador(verticeAtual);
            while(iteradorGrafo.hasNext())
            {
                i = iteradorGrafo.next();
                if(cor[i] == BRANCO){
                    cor[i] = CINZA;
                    pai[i] = verticeAtual;
                    distancia[i] = distancia[verticeAtual] + 1;
                    fila.add(i);
                }
                
            }
            cor[verticeAtual] = PRETO;
        }
        
    }
    
    
    public void imprimirCaminhosLargura(){
        Stack<Integer> pilha = new Stack<Integer>();
        int indexAtual;
        
        for(int i=0;i<representacao.getNumVertices();i++){
            System.out.println("No: " + i);
            System.out.println("Distancia: " + distancia[i]);
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
    
    
    public void caminhoEntreVertices(int inicio,int fim){
        buscaLargura(inicio);
        int indexAtual = fim;
        Stack<Integer> pilha = new Stack<Integer>();
        
        while(indexAtual != -1){
            pilha.add(indexAtual);
            indexAtual = pai[indexAtual];
        }
        if(pilha.peek() != inicio){
            System.out.println("Não existe caminho entre os dois vertices");
        }else{
            indexAtual = pilha.pop();
            System.out.print(indexAtual);
            while(pilha.empty() == false){
                indexAtual = pilha.pop();
                System.out.print("->" + indexAtual);
            }
            System.out.println("\n");
        }
    }

    public int[] getPai() {
        return pai;
    }

}
