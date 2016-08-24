/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesenharGrafo;

/**
 *
 * @author mortz
 */
public class Equation {
    private float[] multX;
    private float[] multY;
    private float independente;
    
    public Equation(int grau){
        multX = new float[grau];
        multY = new float[grau];
    }
    
    public int[] intersection(Equation eq){
        int posi[] = new int[2];
    }
    
    public void setEquationFromElipse(float x0,float y0,float a,float b){
        multX[0] = 1/(a*a);
        multX[1] = (-2 * x0) /(a*a);
        
        multY[0] = 1/(b*b);
        multY[1] = (-2 * y0) /(b*b);
        
        independente = (x0*x0)/(a*a) + (y0*y0)/(b*b) - 1;
    }
    
    public void setEquationFromCirc(float x0, float y0, float r){
        multX[0] = 1;
        multX[1] = -2 * x0;
        
        multY[0] = 1;
        multY[1] = -2 * y0;
        
        independente = (x0 * x0) + (y0 * y0) - (r * r);
    }
    
    public void setMultX(int posi, float valor){
        multX[posi] = valor;
    }
    
    public void setMultY(int posi, float valor){
        multY[posi] = valor;
    }
    
    public void setIdependente(int posi,float valor){
        independente = valor;
    }
    
    public float getMultX(int posi){
        return multX[posi];
    }
    
    public float getMultY(int posi){
        return multY[posi];
    }
    
    public float getInd(){
        return independente;
    }
    
}
