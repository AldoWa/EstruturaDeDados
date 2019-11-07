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
public interface PilhaAoContrario<T> extends Iterable<T>{
    public T PushI(T item);
    public T PopI();
    public int size();
    public T TopI();
    public boolean isEmpty();
}
