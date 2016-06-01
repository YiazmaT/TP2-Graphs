/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscas;

import Iterador.IteratorGrafos;
import grafos.Grafo;
import grafos.ListaAdjacencia;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author mortz
 */
public class Coloracao {
    private int color[];
    private ListaAdjacencia grafo;
    private int proximaCor;
    
    public Coloracao(ListaAdjacencia grafo){
        this.grafo = grafo;
        color = new int[grafo.getNumVertices()];
    }
    
    public void inicializar(){
        for(int i=0;i<grafo.getNumVertices();i++){
            color[i] = -1;
        }
    }
    
    public boolean isColorido(int i ){
        if(color[i] == -1)return false;
        return true;
    }
    
    public int corValida(int i){
        IteratorGrafos iterador;
        PriorityQueue<Integer> coresUsadas = new PriorityQueue<>();
        int corUsada,corAtual;
        iterador = grafo.returnIterador(i);
        
        while(iterador.hasNext()){
            int node = iterador.next();
            if(color[node] != -1)coresUsadas.add(color[i]);
        }
        
        corAtual = 0;
        while(coresUsadas.isEmpty()==false){
            corUsada = coresUsadas.poll();
            if(corUsada != corAtual)return corAtual;
            corAtual++;
        }
        return proximaCor++;
    }
    
    public int[] coloracao(){
        int raiz;
        
        proximaCor = 0;
        raiz = grafo.verticeMaisAdjacencia();
        
        escolherCor(raiz);
        for(int i=0;i<grafo.getNumVertices();i++){
            escolherCor(i);
        }
        
        
        return color;
    }
    
    public void escolherCor(int vertice){
        IteratorGrafos iterador;
        if(!isColorido(vertice)){
            int cor = corValida(vertice);
            color[vertice] = cor;
            
            iterador = grafo.returnIterador(vertice);
            while(iterador.hasNext()){
                escolherCor(iterador.next());
            }
        }
    }
    
}
