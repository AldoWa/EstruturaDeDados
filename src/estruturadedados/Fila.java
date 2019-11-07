/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedados;

/**
 *
 * @author 11645
 */
public interface Fila<T> extends Iterable<T>{
    public boolean enfileirar(T valor);
    public T desenfileirar();
    public int tamanho();
    public boolean vazia();
    public T primeiro();
    public T ultimo();
}
