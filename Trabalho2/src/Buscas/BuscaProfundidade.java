/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscas;

import grafos.Grafo;
import Iterador.IteratorGrafos;
import grafos.Utilitarios;
import java.util.Stack;

/**
 *
 * @author mortz
 */
public class BuscaProfundidade {
    private Grafo representacao;
    private int cor[];
    private int tempoChegada[];
    private int pai[];
    private int tempoFinaliza[];
    private int componentes[];
    private int componenteAtual;
    private int raizBusca;
    private Stack<Integer> ordemTopologica;
    
    private final static int BRANCO = 1;
    private final static int CINZA = 2;
    private final static int PRETO = 3;
    
    public BuscaProfundidade(Grafo representacao){
        this.representacao = representacao;
        cor = new int[representacao.getNumVertices()];
        tempoChegada = new int[representacao.getNumVertices()];
        tempoFinaliza = new int[representacao.getNumVertices()];
        componentes = new int[representacao.getNumVertices()];
        pai = new int[representacao.getNumVertices()];
        ordemTopologica = new Stack<Integer>();
    }
    
    public int getTempoChegada(int i){
        return tempoChegada[i];
    }
    
    public int getTempoFinaliza(int i){
        return tempoFinaliza[i];
    }

    public Stack<Integer> getOrdemTopologica(){
        return ordemTopologica;
    }
    
    //é usado para mostar em qual componente pertence cada vertice
    //por exemplo:
    //
    // componentes[i] == 2 significa que o vertice i esta no componente 2;
    public int[] getComponentes() {
        return componentes;
    }
    
    public boolean grafoConexo(){
        if(componenteAtual == 1)return true;
        return false;
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
    
    public int visitaBuscaProfundidade(int indexVertice,int tempo){
        IteratorGrafos iterador;
        int i;
        componentes[indexVertice] = componenteAtual;
        tempo = tempo + 1;
        cor[indexVertice] = CINZA;
        tempoChegada[indexVertice] = tempo; 
    
        iterador = representacao.returnIterador(indexVertice);
        while(iterador.hasNext()){
            i = iterador.next();
            if(cor[i] == BRANCO){
                pai[i] = indexVertice;
                tempo = visitaBuscaProfundidade(i,tempo);
            }
        }
        
        cor[indexVertice] = PRETO;
        tempo = tempo + 1;
        tempoFinaliza[indexVertice] = tempo;
        ordemTopologica.add(indexVertice);
        return tempo;
    }
    
    public void buscaProfundidade(int raiz){
        componenteAtual = 0;
        int i;
        int tempo = 0;        
        raizBusca = raiz;
        for(i=0;i<representacao.getNumVertices();i++){
            cor[i] = BRANCO;
        }
        
        i = raiz;
        do{
            if(cor[i] == BRANCO){
                componenteAtual = componenteAtual + 1;
                tempo = visitaBuscaProfundidade(i,tempo);
                //Os nós onde se iniciam a buscam recebem -1
                pai[i] = -1;
            }
            i = (i+1)%representacao.getNumVertices();
        }while(i != raiz);
        
        
    }

    
    
}
