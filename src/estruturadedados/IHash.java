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
public interface IHash<K, V> extends Iterable<V>{
    public void inserir(K chave, V valor);
    public V obter(K chave);
    public V remover(K chave);
    public boolean existe(K chave);
    public boolean contem(V valor);
    public int tamanho();
    public void limpar();
}
