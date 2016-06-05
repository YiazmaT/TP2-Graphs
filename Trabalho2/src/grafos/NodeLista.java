/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author mortz
 */

public class NodeLista{
    private int numVertice;
    private int valorAresta;
    private NodeLista prox;
    
    public NodeLista(){}
    
    public NodeLista(int numVertice,int valorAresta, NodeLista prox){
        this.numVertice = numVertice;
        this.valorAresta = valorAresta;
        this.prox = prox;
    }

    public int getValorAresta() {
        return valorAresta;
    }

    public void setValorAresta(int valorAresta) {
        this.valorAresta = valorAresta;
    }
    
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public void setProx(NodeLista prox) {
        this.prox = prox;
    }
    
    public int getNumVertice() {
        return numVertice;
    }

    public NodeLista getProx() {
        return prox;
    }
}

