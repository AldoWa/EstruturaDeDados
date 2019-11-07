/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package Hashmap;

import ArrayList.ArrayList;
import ListaDuplamenteEncadeada.ListaEncadeadaDupla;

import estruturadedados.IHash;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hashmap<K, T> implements IHash<K, T> {

    private ArrayList<ListaEncadeadaDupla<NoHash<K, T>>> tabela;
    private int tamanho;

    public Hashmap() {
        tabela = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tabela.adicionar(new ListaEncadeadaDupla<>());
        }
    }

    private ArrayList<ListaEncadeadaDupla<NoHash<K, T>>> retornarLista() {
        ArrayList<ListaEncadeadaDupla<NoHash<K, T>>> lista = new ArrayList<>();
        for (ListaEncadeadaDupla<NoHash<K, T>> listaNos : this.tabela) {
            lista.adicionar(listaNos);
        }
        return lista;
    }

    private int geradorIndice(K chave) {
        return Math.abs(chave.hashCode() % this.tabela.size());
    }

    @Override
    public void inserir(K chave, T valor) {
        this.verificiarCarga();
        if (this.existe(chave)) {
            this.remover(chave);
        }
        int indice = geradorIndice(chave);
        ListaEncadeadaDupla<NoHash<K, T>> lista = this.tabela.buscar(indice);
        lista.adicionar(new NoHash(chave, valor));
        this.tamanho++;
    }

    @Override
    public T obter(K chave) {
        int indice = this.geradorIndice(chave);
        ListaEncadeadaDupla<NoHash<K, T>> lista = this.tabela.buscar(indice);

        for (NoHash<K, T> no : lista) {
            if (no.getChave().equals(chave)) {
                return no.getValor();
            }
        }

//        for (int i = 0; i < lista.size(); i++) {
//            NoHash<K,T> no = lista.buscar(i);
//            if(no.getChave().equals(chave)){
//                return no.getValor();
//            }
//        }
        throw new IllegalArgumentException("Chave nao existe");

    }

    @Override
    public T remover(K chave) {
        int indice = this.geradorIndice(chave);
        ListaEncadeadaDupla<NoHash<K, T>> lista = tabela.buscar(indice);

        for (int i = 0; i < lista.size(); i++) {
            NoHash<K, T> no = lista.buscar(i);
            if (no.getChave().equals(chave)) {
                NoHash<K, T> noRemovido = lista.remover(i);
                this.tamanho--;
                return noRemovido.getValor();

            }
        }
        throw new IllegalArgumentException("Chave nao existe");
    }

    @Override
    public boolean existe(K chave) {
        int indice = this.geradorIndice(chave);
        ListaEncadeadaDupla<NoHash<K, T>> lista = this.tabela.buscar(indice);

        for (NoHash<K, T> no : lista) {
            if (no.getChave().equals(chave)) {
                return true;
            }

        }

//        for (int i = 0; i < lista.size(); i++) {
//            NoHash<K,T> no = lista.buscar(i);
//            if(no.getChave().equals(chave)){
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean contem(T valor) {
        for (int i = 0; i < this.tabela.size(); i++) {
            ListaEncadeadaDupla<NoHash<K, T>> listano = tabela.buscar(i);
            for (int j = 0; j < listano.size(); j++) {
                NoHash no = listano.buscar(j);
                if (no.getValor().equals(valor)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public void limpar() {
        int tamanhoVetor = this.tabela.size();
        this.tabela.limpar();
        for (int i = 0; i < tamanhoVetor; i++) {
            this.tabela.adicionar(new ListaEncadeadaDupla<>());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;

    }

    @Override
    public String toString() {
        return this.retornarLista().toString();
    }

    private void verificiarCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;
        if (carga > 0.75) {
            this.reindimencionarTabela(capacidade * 2);
        }
    }

    private void reindimencionarTabela(int novaCapacidade) {
        ArrayList<ListaEncadeadaDupla<NoHash<K, T>>> lista = this.retornarLista();
        this.tabela.limpar();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.adicionar(new ListaEncadeadaDupla<>());
        }

        for (int i = 0; i < lista.size(); i++) {
            ListaEncadeadaDupla<NoHash<K, T>> listaNos = lista.buscar(i);
            for (NoHash<K, T> no : listaNos) {
                K key = no.getChave();
                int novoIndice = geradorIndice(key);
                ListaEncadeadaDupla<NoHash<K, T>> listaNo = this.tabela.buscar(novoIndice);
                listaNo.adicionar(new NoHash(key, no.getValor()));
            }
        }

    }
private class HashMapIterator implements Iterator {

        private int linhaAtual;
        private Iterator iteratorDaLinkedList;
        private int quantidadeTotal;
        private int elementosPercorridos;
        private NoHash<K, T> cursor;
        private NoHash<K, T> ultRetornado;

        public HashMapIterator() {
            this.elementosPercorridos = 0;
            this.quantidadeTotal = tamanho();
            this.linhaAtual = 0;
            this.iteratorDaLinkedList = tabela.buscar(linhaAtual++).iterator();
            //Enquanto for retornado um iterator que nao possui proximo
            while (!this.iteratorDaLinkedList.hasNext()) {
                this.iteratorDaLinkedList = tabela.buscar(linhaAtual++).iterator();
            }
            this.cursor = (NoHash<K, T>) this.iteratorDaLinkedList.next();
            this.ultRetornado = null;
        }

        @Override
        public boolean hasNext() {
            return this.elementosPercorridos != this.quantidadeTotal;
        }

        @Override
        public T next() {
            if (this.elementosPercorridos == this.quantidadeTotal) {
                throw new NoSuchElementException();
            }
            //A variavel verifica iterator ira checar se existe ainda algum iterator que podera ser utilizado
            boolean verificaIterator = true;
            this.elementosPercorridos++;
            this.ultRetornado = cursor;
            //Enquanto for retornado um iterator que nao possui proximo
            while (!this.iteratorDaLinkedList.hasNext()) {
                if (linhaAtual == tabela.size()) {
                    verificaIterator = false;
                    break;
                }
                this.iteratorDaLinkedList = tabela.buscar(linhaAtual++).iterator();
            }
            //Caso ainda tenha iterators a serem utilizados
            if (verificaIterator) {
                this.cursor = (NoHash<K, T>) this.iteratorDaLinkedList.next();
                //Caso o cursor tenha chegado no ultimo elemento da linked list atual
                if (this.cursor == null) {
                    while (this.cursor == null) {
                        if (linhaAtual == tabela.size()) {
                            break;
                        }
                        this.iteratorDaLinkedList = tabela.buscar(linhaAtual++).iterator();
                        this.cursor = (NoHash<K, T>) this.iteratorDaLinkedList.next();
                    }
                }
            }
            return ultRetornado.getValor();
        }

    }
}
