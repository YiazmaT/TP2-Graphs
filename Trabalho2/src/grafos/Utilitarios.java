package grafos;

import DesenharGrafo.Edge;
import DesenharGrafo.Graph;
import DesenharGrafo.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilitarios{
    public static String getCaminho(int indexVertex,int pai[],int raizBusca)
    {
        String caminho = new String("");
        Stack<Integer> pilha = new Stack<Integer>();
        int indexAtual;
        
        if(indexVertex == raizBusca)return "Raiz";
        
        indexAtual = indexVertex;
        while(indexAtual != -1)
        {
            pilha.push(indexAtual);
            indexAtual = pai[indexAtual];
        }
        
        indexAtual = pilha.pop();
        if(indexAtual == indexVertex)return "Não Alcança";
        caminho = caminho + indexAtual;
        while(pilha.empty() == false)
        {
            indexAtual = pilha.pop();
            caminho = caminho + "->" + indexAtual;
        }
        
        return caminho;
    }
    
    
    public static ListaAdjacencia leitura(String arquivo)
    {
        Scanner sc;
        File f = new File(arquivo);
        try{
            sc = new Scanner(f);
            int isDigrafo = sc.nextInt();
            int numVertice = sc.nextInt();
            ListaAdjacencia grafos = new ListaAdjacencia(numVertice,isDigrafo == 1);
            
            while(sc.hasNext())
            {
                int nodeA = sc.nextInt();
                int nodeB = sc.nextInt();
                int valor = sc.nextInt();
                
                grafos.inserirAdjacencia(nodeA, nodeB, valor);
                
            }
            
            sc.close();
            return(grafos); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            return(null);
        }
    }
    
    
    
}
