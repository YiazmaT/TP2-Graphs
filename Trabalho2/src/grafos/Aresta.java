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
public class Aresta implements Comparable<Aresta>{
    private int nodeA;
    private int nodeB;
    private int valor;

    
    
    
    public Aresta(){}
    
    public Aresta(int nodeA, int nodeB, int valor){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.valor = valor;
    }
    
    public int getNodeA() {
        return nodeA;
    }

    public void setNodeA(int nodeA) {
        this.nodeA = nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public void setNodeB(int nodeB) {
        this.nodeB = nodeB;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Aresta o) {
        if(this.valor < o.getValor())return -1;
        if(this.valor == o.getValor())return 0;
        return 1;
    }
}
