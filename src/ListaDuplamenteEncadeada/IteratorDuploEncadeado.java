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
public class IteratorDuploEncadeado<T> implements Iterator<T>{
    private No<T> atual;
    public IteratorDuploEncadeado(No<T> primeiro) {
        this.atual = primeiro;
    }
    
   
    @Override
    public boolean hasNext() {
        return this.atual != null;
    }

    @Override
    public T next() {
         T retorno = this.atual.getElemento();
        this.atual = this.atual.getProximo();
        return retorno;
    }
    
}
