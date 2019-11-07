/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author Aldo
 */
public class No<T> {
    private No anterior;
    private No proximo;
    private T elemento;
    
    public No(No anterior, No proximo, T elemento) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public No(No proximo, T elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }


    public No(T elemento) {
        this.elemento = elemento;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    //Para uso do hashMap
    
}
