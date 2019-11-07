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
public interface Lista<T> {
    public abstract void adicionar(T elemento);
    public abstract void adicionarNoInicio(T elemento);
    public abstract void adicionarNoFim(T elemento);
    public abstract void adicionar(T elemento, int posicao);
    
    public abstract T remover(int posicao);
    public abstract T removerNoInicio();
    public abstract T removerNoFim();
    
    public abstract T buscar(int posicao);
    public abstract boolean existe(T elemento);
   
    public abstract void limpar();
    
}
