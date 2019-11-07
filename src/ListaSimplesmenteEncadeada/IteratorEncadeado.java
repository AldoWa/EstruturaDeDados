/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesmenteEncadeada;

import java.util.Iterator;

/**
 *
 * @author Aldo
 */
public class IteratorEncadeado<T> implements Iterator {
    private No<T> atual;

    public IteratorEncadeado(No<T> inicio) {
       this.atual = inicio;
    }
    
    @Override
    public boolean hasNext() {
        return atual != null;
    }

    @Override
    public Object next() {
        T retorno = this.atual.getElemento();
        this.atual = this.atual.getProximo();
        return retorno;
    }
    
}
