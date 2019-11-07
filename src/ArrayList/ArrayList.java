/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

import ArrayListAtividade.Disciplina;
import estruturadedados.Lista;
import estruturadedados.Lista;
import java.util.Iterator;
import estruturadedados.Fila;
import estruturadedados.Pilha;

/**
 *
 * @author Aldo
 */
public class ArrayList<T> implements Lista<T>, Iterable<T>, Fila<T>,Pilha<T> {

    private int tamanho;
    private T[] Lista;
    private int tamanhoVetor = 1;
    private int retornarTamanho;

    public ArrayList() {
        Lista = (T[]) new Object[tamanhoVetor];
    }

    //  get(int index) : LinkedList O(n) e ArrayList O(1)
//  add(E element) : LinkedList O(1) e ArrayList O(n) no pior caso (que é quando o vetor tem que ser redimensionado e copiado para um novo array)
//  add(int index, E element) : LinkedList O(n) e ArrayList O(n) no pior caso
//  remove(int index) : LinkedList O(n) e ArrayList O (n-index), se remover o último elemento então fica O(1)
    @Override
    public void adicionar(T elemento) {
        gerarespaco();
        Lista[tamanho] = elemento;
        tamanho = tamanho + 1;
    }

    @Override
    public void adicionarNoInicio(T elemento) {
        adicionar(elemento, 0);
    }

    @Override
    public void adicionarNoFim(T elemento) {
        adicionar(elemento);
    }

    @Override
    public void adicionar(T elemento, int posicao) {
        this.gerarespaco();
        if (!posicaoocupada(posicao)) {
            throw new IllegalArgumentException("Posicao invalida");
        }
        for (int i = tamanho - 1; i >= posicao; i--) {
            this.Lista[i + 1] = this.Lista[i];
        }
        this.Lista[posicao] = elemento;
        this.tamanho = this.tamanho + 1;

    }

    @Override
    public T remover(int posicao) {
        T valorremovido = Lista[posicao];
        if (!posicaoexiste(posicao)) {
            throw new IllegalArgumentException("Posicao invalida");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            this.Lista[i] = this.Lista[i + 1];
        }
        this.tamanho = this.tamanho - 1;
        this.Lista[this.tamanho] = null;
        return valorremovido;
    }

    @Override
    public T removerNoInicio() {
        remover(0);
        return Lista[0];
    }

    @Override
    public T removerNoFim() {
        remover(tamanho - 1);
        return Lista[tamanho - 1];
    }

    @Override
    public T buscar(int posicao) {
        return Lista[posicao];
    }

    @Override
    public boolean existe(T elemento) {

        for (int i = 0; i < tamanho; i++) {
            if (elemento.equals(Lista[i])) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void limpar() {

        for (int i = 0; i < tamanho; i++) {
            Lista[i] = null;
            tamanho = 0;
        }
    }

    public int tamanho() {

        return this.tamanho;
    }

    public void gerarespaco() {
        if (this.tamanho == this.Lista.length) {
            T[] ListaNova = (T[]) new Object[this.Lista.length * 2];
            for (int i = 0; i < this.Lista.length; i++) {
                ListaNova[i] = this.Lista[i];
            }
            this.Lista = ListaNova;
        }
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            SB.append(Lista[i] + "  ");
        }
        return SB.toString();
    }

    public boolean posicaoexiste(int posicao) {
        return posicao >= 0 && posicao < tamanho;
    }

    public boolean posicaoocupada(int posicao) {
        return posicao >= 0 && posicao <= tamanho;
    }

    public Iterator<T> iterator() {
        return new Data();
    }

    public int indexOf(T elemento) {
        int indice = 0;
        for (int i = 0; i < tamanho; i++) {
            if (elemento.equals(Lista[i])) {
                indice = i;
            }
        }
        return indice;
    }

    //Para fila
    private int fim = 0;
    private int inicio = 0;

    private void garantirEspacoFila() {

        if (this.tamanho == this.Lista.length) {

            T[] ListaNova = (T[]) new Object[this.Lista.length * 2];
            this.tamanhoVetor = ListaNova.length;
            int posicao = this.inicio;
            for (int i = 0; i < this.Lista.length; i++) {
                ListaNova[i] = Lista[posicao];
                if (posicao == this.Lista.length - 1) {
                    posicao = 0;
                } else {
                    posicao++;
                }
            }
            this.Lista = ListaNova;
            this.inicio = 0;
            this.fim = this.tamanho;
        }

    }

    @Override
    public boolean enfileirar(T valor) {
        this.garantirEspacoFila();
        this.Lista[this.fim] = valor;
        if (this.fim == this.tamanhoVetor) {
            this.fim = 0;
        } else {
            this.fim++;
        }

        this.tamanho++;

        return true;
    }

    @Override
    public T desenfileirar() {
        if (this.tamanho == 0) {
            throw new NullPointerException("Esta vazio");
        }
        T elemento = this.Lista[this.inicio];
        this.Lista[this.inicio] = null;
        
        if (this.inicio == this.tamanhoVetor) {
            this.inicio = 0;
        } else {
            this.inicio++;
        }
        this.tamanho--;
        return elemento;
    }

    @Override
    public boolean vazia() {
        return this.tamanho == 0;
    }

    @Override
    public T primeiro() {
        return this.Lista[0];
    }

    @Override
    public T ultimo() {
        return this.Lista[this.tamanho];
    }

    @Override
    public T Push(T item) {
        this.adicionarNoFim(item);
        return item;
    }

    @Override
    public T Pop() {
        T elemento = this.removerNoFim();
        return elemento;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public T Top() {
        return this.Lista[this.tamanho - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    private class Data implements Iterator<T> {

        private int posicao = 0;

        @Override
        public boolean hasNext() {

            if (posicao < tamanho) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return Lista[posicao++];

            } else {
                return null;
            }
        }

    }
}
