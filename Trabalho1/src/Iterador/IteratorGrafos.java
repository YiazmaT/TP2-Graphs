/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import java.util.Iterator;

/**
 *
 * @author mortz
 */
public abstract class IteratorGrafos implements Iterator<Integer>{
   
    
    public abstract boolean hasNext();
    public abstract Integer next();
    public abstract Integer valor();
}
