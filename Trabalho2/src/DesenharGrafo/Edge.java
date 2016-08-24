/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DesenharGrafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author Danilo Medeiros Eler
 */
public class Edge {

    private Color color = Color.WHITE; //Cor da aresta
    private Vertex source; //primeiro vetice da aresta
    private Vertex target; //segundo vertice da aresta
    private Boolean directed = true; //se a aresta é direcionada
    private Boolean selected = false; //se a aresta está selecionada
    private int arqueado = 0;
    private int peso=0;
    
    public Edge(Vertex source, Vertex target, int peso, boolean directed) {
        this.source = source;
        this.target = target;
        this.peso = peso;
        this.directed = directed;
        arqueado = 0;
        if(source.getID() == target.getID())arqueado = 3;
    }

    public void setArqueado(int arqueado){
        this.arqueado = arqueado;
    }
    
    public void setStrokeComposite(Graphics2D g2){
        if (selected) {
            g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
            g2.setStroke(new java.awt.BasicStroke(5.0f));            
        } else {
            g2.setStroke(new java.awt.BasicStroke(1.0f));
            if ((this.target.isSelected() && this.source.isSelected())) { //se os vertices estao selecionados
                g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.5f));
            } else {//se os vertices nao estao selecionados
                g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.2f));
            }
        }
    }
    
    public void drawEdge(Graphics2D g2){
        this.color = new Color((this.source.getColor().getRed() + this.target.getColor().getRed()) / 2,
                (this.source.getColor().getGreen() + this.target.getColor().getGreen()) / 2,
                (this.source.getColor().getBlue() + this.target.getColor().getBlue()) / 2);

        g2.setColor(this.color);
        
        int diferenca = (int)(target.getX()-source.getX());
        
        switch(arqueado){
            case 0:
                g2.drawLine(((int) this.source.getX()), ((int) this.source.getY()),
                ((int) this.target.getX()), ((int) this.target.getY()));
                break;
                
            case 1:
                g2.drawArc((int)source.getX(), (int)source.getY()- diferenca/75*10, 
                    diferenca,
                    diferenca/75*20,0, 180);
                break;
                
            case -1:
                g2.drawArc((int)source.getX(), (int)source.getY()- diferenca/75*10, 
                    diferenca,
                    diferenca/75*20,0, -180);
                break;
        }
        
        
    }
    
    
    public void drawArrow(Graphics2D g2){
        if (isDirected()) {
//            drawArrow(g2, new Point((int) source.getX(), (int) source.getY()),
//                    new Point((int) target.getX(), (int) target.getY()),
//                    6.0f);
            if(arqueado == 0){
                if(!selected){
                    g2.setStroke(new java.awt.BasicStroke(1.0f));    
                    drawArrowNew(g2, new Point((int) source.getX(), (int) source.getY()),
                            new Point((int) target.getX(), (int) target.getY()),
                            6, 14);
                }else{
                    g2.setStroke(new java.awt.BasicStroke(4.0f));    
                    drawArrowNew(g2, new Point((int) source.getX(), (int) source.getY()),
                            new Point((int) target.getX(), (int) target.getY()),
                            6, 14);
                }
            }else{
                drawArrowArqueado(g2);
            }
        }

    }
    
    public float calculaIntersecX(){
        float centroEliX = (target.getX() + source.getX())/2;
        float centroEliY = source.getY();
        float centroCirX = target.getX();
        float centroCirY = target.getY();
        float a,b,h,r;
        float intersecX,intersecY;
        
        a = (target.getX() - centroEliX);
        b = (target.getX()-source.getX())/75*10;
        h = (centroCirX - centroEliX);
        r = target.getRay();
        
        Equation2ndGrau intersection = new Equation2ndGrau(1 - (b*b)/(a*a), -2*h, b*b + h*h - r*r);
        intersection.calcular();
   
        float result1,result2;
        result1 = intersection.result1;
        result2 = intersection.result2;
        
        //result1 = (float) (r*r - Math.pow(result1 - h, 2));
        //result2 = (float) (r*r - Math.pow(result2 - h, 2));
        
        if((r*r - Math.pow(result1 - h, 2) < 0))return result2;
        else return result1;
    }
    
    public void drawArrowArqueado(Graphics2D g2){
        float intersecX,intersecY;
        
        intersecX = calculaIntersecX();
        intersecY = (float) Math.sqrt(target.getRay()*target.getRay() - Math.pow(intersecX -(target.getX() - (target.getX() + source.getX())/2),2));
    
        if(arqueado == 1)intersecY*=-1;
        
        
        
        intersecY+=target.getY();
        intersecX+=(target.getX() + source.getX())/2;
        
        
        Point ptoControle = new Point((int)(intersecX + (intersecX - target.getX())),(int)(intersecY + (intersecY - target.getY())));
//        float r = (float)Math.sqrt(Math.pow(ptoControle.x,2) + Math.pow(ptoControle.y,2));
//        
        ptoControle.x = (int) (ptoControle.x - intersecX) ;
        ptoControle.y = (int) (ptoControle.y - intersecY);
//        
        Point setaA = new Point(),setaB = new Point();
//       
        float angulo = (float) Math.toRadians(45);
        setaA.x =  (int) ((ptoControle.x*cos(angulo) - ptoControle.y*sin(angulo)) + intersecX);
        setaA.y =  (int) ((ptoControle.x*sin(angulo) + ptoControle.y*cos(angulo)) + intersecY);
//        
        angulo = (float)Math.toRadians(-45);
        setaB.x =  (int) (ptoControle.x*cos(angulo) - ptoControle.y*sin(angulo)+intersecX);
        setaB.y =  (int) (ptoControle.x*sin(angulo) + ptoControle.y*cos(angulo)+intersecY);
//        
//        ptoControle.x +=intersecX;
//        ptoControle.y +=intersecY;
//        
//        System.out.println(ptoControle.x);
//        System.out.println(ptoControle.y);
//        System.out.println(setaA.x);
//        System.out.println(setaA.y);
//        System.out.println();
//        
        
          //g2.fillOval(setaA.x - 3, setaA.y-3, 6, 6);
          //g2.fillOval(setaB.x - 3, setaB.y-3, 6, 6);
          //g2.fillOval(ptoControle.x-3, ptoControle.y -3, 6, 6);
        g2.drawLine(setaA.x, setaA.y, (int)intersecX, (int)intersecY);
        g2.drawLine(setaB.x, setaB.y, (int)intersecX, (int)intersecY);
    }
    
    public void drawPeso(Graphics2D g2){
        int diferenca = (int)(target.getX()-source.getX());
        if(arqueado == 0){
            g2.drawString(String.valueOf(peso), (int)(source.getX() + target.getX())/2, (int)(source.getY() + target.getY())/2);
        }else{
            if(arqueado == 1){
                g2.drawString(String.valueOf(peso),(int)(source.getX() + target.getX())/2, source.getY() - diferenca/75*10);
            }else{
                g2.drawString(String.valueOf(peso),(int)(source.getX() + target.getX())/2, source.getY() + diferenca/75*10 + 10);
            }
        }
       
    }
    
    public void draw(java.awt.Graphics2D g2) {
        //Combines the color of the two vertex to paint the edge
        setStrokeComposite(g2);
        drawEdge(g2);
        drawArrow(g2);
        drawPeso(g2);
        
         g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
         g2.setColor(Color.BLACK);
        
  
        
    }
    
    public int getSourceID(){
        return source.getID();
    }
    
    public int getTargetID(){
        return target.getID();
    }
    
 
    private void drawArrowNew(Graphics2D g2, Point s, Point t, int size, int deslocamento) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / r;
        float sen = (t.y - s.y) / r;                
        
        int xAB = size + deslocamento;
        int yA = size;
        int yB = -size;
        
        Point pa = new Point(Math.round( xAB * -cos - yA * -sen )+t.x, Math.round( xAB * -sen + yA * -cos )+t.y);
        Point pb = new Point(Math.round( xAB * -cos - yB * -sen )+t.x, Math.round( xAB * -sen + yB * -cos )+t.y);
        Point pc = new Point(Math.round( deslocamento * -cos)+t.x, Math.round( deslocamento * -sen)+t.y);
        
        g2.drawLine(pc.x, pc.y, pa.x, pa.y);
        g2.drawLine(pc.x, pc.y, pb.x, pb.y);
    }

    private void drawArrow(Graphics2D g2, Point s, Point t, float size) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / (r);
        float sen = (t.y - s.y) / (r);

        //rotação e translação
        int transX = (int) ((t.x + s.x) * 0.5f); //metade da reta
        int transY = (int) ((t.y + s.y) * 0.5f); //metade da reta

        Point pa = new Point(Math.round(-sen * size) + (transX), Math.round(cos * size) + (transY));
        Point pb = new Point(Math.round(-sen * -size) + (transX), Math.round(cos * -size) + (transY));
        Point pc = new Point(Math.round(cos * size) + (transX), Math.round(sen * size) + (transY));

        g2.drawLine(pa.x, pa.y, pc.x, pc.y);
        g2.drawLine(pb.x, pb.y, pc.x, pc.y);

//        g2.setFont(new Font("Verdana", Font.BOLD, 10));
//        java.awt.FontMetrics metrics = g2.getFontMetrics(g2.getFont());
//        g2.drawString("T", pc.x, pc.y);
    }

    public Boolean isDirected() {
        return directed;
    }

    public void setDirected(Boolean directed) {
        this.directed = directed;
    }
    
    public void setSelected(Boolean selected){
        this.selected = selected;
    }
    
    private class Equation2ndGrau{
        public float a;
        public float b;
        public float c;
        
        public float result1;
        public float result2;
        
        public Equation2ndGrau(float a,float b,float c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public void calcular(){
            float delta = b*b - 4*a*c;
            delta = (float) Math.sqrt(delta);
            
            result1 = (-b + delta)/(2*a);
            result2 = (-b - delta)/(2*a);
        }
    }
}
