/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

import java.util.Iterator;

/**
 *
 * @author Aldo
 */
public class IteratorReverso<T> implements Iterator<T> {
    No<T> ultimo;
    public IteratorReverso(No ultimo) {
     this.ultimo = ultimo;
    }
    No<T> atual = this.ultimo;
    @Override
    public boolean hasNext() {
        return atual!=null;
    }

    @Override
    public T next() {
        T elemento = atual.getElemento();
        this.atual = this.atual.getAnterior();
        return elemento;
    }
    
}
