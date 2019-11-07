/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedados;

/**
 *
 * @author Aldo
 */
public interface Pilha<T> extends Iterable<T>{
    public T Push(T item);
    public T Pop();
    public int size();
    public T Top();
    public boolean isEmpty();
    
}
