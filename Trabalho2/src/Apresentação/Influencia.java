package Apresentação;

import Buscas.BuscaLargura;
import grafos.ListaAdjacencia;

public class Influencia { 
    public int[] calcularInfluencia(ListaAdjacencia grafo){
        //criar vetores de influencia
        int [] influenciaTotal = new int [grafo.getNumVertices()]; 
        int [] influenciaParcial = new int [grafo.getNumVertices()];
        
        //calcula transposta
        grafo = grafo.calcularTransposta();
        
        this.calcularInfluenciaParcial(grafo, influenciaParcial);
        this.calcularInfluenciaTotal(grafo, influenciaParcial, influenciaTotal);
        
        return influenciaTotal;
    }
    
    public void calcularInfluenciaParcial(ListaAdjacencia grafo, int[] influenciaParcial){
        //instancia busca em largura
        BuscaLargura busca = new BuscaLargura(grafo);
        
        //vetor de distancia auxiliar
        int [] distanciaAuxilar;
        
        for(int i = 0; i < grafo.getNumVertices(); i++){
            busca.buscaLargura(i);
            distanciaAuxilar = busca.getVetorDistancia(); //pegar vetor de distancias
            
            int cont=0; // contar influencia parcial;
            //calcular influencia parcial
            for(int j=0;j<grafo.getNumVertices();j++){
                //para cada vertice com distancia 1, aumenta em 1 a influencia do vertice
                if(distanciaAuxilar[j] == 1){
                    cont++;
            }
            //atribuir influencia parcial
            influenciaParcial[i] = cont;
        }
    }
    
                }
                
    public void calcularInfluenciaTotal(ListaAdjacencia grafo, int[] influenciaParcial, int[] influenciaTotal){
        //instancia busca em largura
        BuscaLargura busca = new BuscaLargura(grafo);
        
        //vetor de distancia auxiliar
        int [] distanciaAuxilar;

        //calculando influencia total
        for(int i=0;i<grafo.getNumVertices();i++){
            busca.buscaLargura(i);
            distanciaAuxilar = busca.getVetorDistancia(); //pegar vetor de distancias
            
            //iniciando influencia total
            influenciaTotal[i] = influenciaParcial[i];
            
            for(int j=0;j<grafo.getNumVertices();j++){
                //para cada vertice com distancia 1, aumenta em 1 a influencia do vertice
                if(distanciaAuxilar[j] == 1){
                    influenciaTotal[i] += influenciaParcial[j];
                }
            }
        }
    }
}
