/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import Iterador.IteratorLista;
import Iterador.IteratorGrafos;
import ÁrvoreGeradoraMinima.AgmPrim;
import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;
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
public class ListaAdjacencia extends Grafo{
           private NodeLista[] vertices;
          
    public ListaAdjacencia(int numVertices,boolean orientado) {
        vertices = new NodeLista[numVertices];
        super.setNumVertices(numVertices);
        this.orientado = orientado;
        
        for(int i=0;i<numVertices;i++){
            vertices[i] = new NodeLista(i,-1,null);
        }
        
    }
    
    
           @Override
    public boolean inserirAdjacencia(int nodeA, int nodeB,int valor){
        NodeLista nodeAtual,nodeAnterior;
     
        if(nodeA > this.numVertices || nodeB > this.numVertices || nodeA < 0 || nodeB < 0){
            return false;
        }
        
        nodeAnterior =this.vertices[nodeA];
        nodeAtual = nodeAnterior.getProx();
        while(nodeAtual != null && nodeAtual.getNumVertice() < nodeB){
            nodeAnterior = nodeAtual;
            nodeAtual = nodeAtual.getProx();
        }   
        nodeAnterior.setProx(new NodeLista(nodeB,valor,nodeAtual));
        
        if(!orientado && nodeA != nodeB){
            nodeAnterior = this.vertices[nodeB];
            nodeAtual = nodeAnterior.getProx();   
            while(nodeAtual != null && nodeAtual.getNumVertice() < nodeA){
                nodeAnterior = nodeAtual;
                nodeAtual = nodeAtual.getProx();
            }
            nodeAnterior.setProx(new NodeLista(nodeA,valor,nodeAtual));
        }
        return true;
    }
    
    public boolean isAdjacente(int nodeA, int nodeB){
        NodeLista nodeAtual;
        
        nodeAtual = vertices[nodeA].getProx();   
        while(nodeAtual != null && nodeAtual.getNumVertice() < nodeB){
            nodeAtual = nodeAtual.getProx();
        }
        
        if(nodeAtual != null && nodeAtual.getNumVertice() == nodeB)return true;
        return false;
    }
    
    public NodeLista retornoLista(int node){
        return vertices[node].getProx();
    }
    
    public void imprimir(){
        int i;
        NodeLista nodeAtual;
        for(i=0;i<this.numVertices;i++){
            nodeAtual = this.vertices[i];
            System.out.print(i + "-> ");
            nodeAtual = nodeAtual.getProx();
            while(nodeAtual != null){
                System.out.print(nodeAtual.getNumVertice() + "(" + nodeAtual.getValorAresta() + ")" + "-> ");
                nodeAtual = nodeAtual.getProx();
            }
            System.out.println("null");
        }
    }

    @Override
    public IteratorGrafos returnIterador(int vertice) {
        return new IteratorLista(vertices[vertice].getProx());
    }

 

    @Override
    public PriorityQueue<Aresta> getArestas() {
        PriorityQueue<Aresta> arestas = new PriorityQueue<Aresta>();
        IteratorGrafos iterador;
        int verticeAdjacente, valorAresta;
        
        for(int i=0;i<numVertices;i++){
            iterador = this.returnIterador(i);
            while(iterador.hasNext()){
                valorAresta = iterador.valor();
                verticeAdjacente = iterador.next();
            
                arestas.add(new Aresta(i,verticeAdjacente,valorAresta));
                
            }
        }
        return arestas;
    }

    public ListaAdjacencia calcularTransposta()
    {
        ListaAdjacencia transposta = new ListaAdjacencia(numVertices, true);
        IteratorGrafos iterador;
        int verticeAdj,valorAdj;
        for(int i =0;i<numVertices;i++)
        {
            iterador = returnIterador(i);
            while(iterador.hasNext())
            {
                valorAdj = iterador.valor();
                verticeAdj = iterador.next();
                
                transposta.inserirAdjacencia(verticeAdj, i, valorAdj);
            }
        }
        return transposta;
    }
    
    @Override
    public int getPesoAresta(int nodeA, int nodeB) {
        NodeLista nodeAtual = vertices[nodeA].getProx();
        
        while(nodeAtual.getNumVertice() < nodeB && nodeAtual.getProx() != null){
            nodeAtual = nodeAtual.getProx();
        }
        return nodeAtual.getValorAresta();
    }

    
    public int verticeMaisAdjacencia(){
        NodeLista nodeAtual;
        int contAtual, contMaior = 0;
        int posiMaior = 0;
        for(int i=1;i<numVertices;i++){
            nodeAtual = vertices[i].getProx();
            contAtual = 0;
            while(nodeAtual != null){
                nodeAtual = nodeAtual.getProx();
                contAtual++;
            }
            if(contAtual > contMaior){
                posiMaior = i;
                contMaior = contAtual;
            }
        }
        return posiMaior;
    }
    
}

