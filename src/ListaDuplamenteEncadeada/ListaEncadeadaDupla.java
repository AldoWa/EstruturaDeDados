/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

import estruturadedados.Fila;
import estruturadedados.Lista;
import estruturadedados.Pilha;
import estruturadedados.PilhaAoContrario;
import java.util.Iterator;

/**
 *
 * @author Aldo
 */
public class ListaEncadeadaDupla<T> implements Lista<T>, Fila<T>, Iterable<T>, Pilha<T>, PilhaAoContrario<T> {

    private int tamanho = 0;
    private No<T> primeiro;
    private No<T> ultimo;

    @Override
    public void adicionar(T elemento) {
        adicionarNoFim(elemento);
    }

    @Override
    public void adicionarNoInicio(T elemento) {
        if (this.tamanho == 0) {
            No novo = new No(elemento);
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            No novo = new No(primeiro, elemento);
            this.primeiro.setAnterior(novo);
            this.primeiro = novo;
        }
        this.tamanho++;
    }

    @Override
    public void adicionarNoFim(T elemento) {
        if (this.tamanho == 0) {
            this.adicionarNoInicio(elemento);
        } else {
            No nova = new No(elemento);
            this.ultimo.setProximo(nova);
            nova.setAnterior(this.ultimo);
            this.ultimo = nova;
            this.tamanho++;
        }

    }

    @Override
    public void adicionar(T elemento, int posicao) {
        if (this.tamanho == 0) {
            adicionarNoInicio(elemento);
        } else if (posicao == this.tamanho) {
            adicionarNoFim(elemento);
        } else {
            No anterior = this.PegarNo(posicao - 1);
            No proximo = anterior.getProximo();
            No nova = new No(anterior.getProximo(), elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proximo.setAnterior(nova);

            this.tamanho++;
        }
    }

    @Override
    public T remover(int posicao) {
        
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Não existe essa posicao para remover");
        }
        T elemento = buscar(posicao);
        if (posicao == this.tamanho - 1) {
            this.removerNoFim();
        } else if (posicao == 0) {
            this.removerNoInicio();
        } else {
            No anterior = this.PegarNo(posicao - 1);
            No atual = anterior.getProximo();
            No proximo = atual.getProximo();
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
            this.tamanho--;
        }
        return elemento;
    }

    @Override
    public T removerNoInicio() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Nao existe lugar para remover");
        }
        T elemento = (T) primeiro.getElemento();
        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
        if (this.tamanho == 0) {
            this.ultimo = null;
        }
        return elemento;
    }

    @Override
    public T removerNoFim() {
        T elemento = null;
        if (!this.posicaoOcupada(this.tamanho - 1)) {
            throw new IllegalArgumentException("Nao existe lugar para remover");
        }
        if (this.tamanho == 1) {
            this.removerNoInicio();
        } else {
            elemento = (T) ultimo.getElemento();
            No penultima = this.ultimo.getAnterior();
            penultima.setProximo(null);
            this.ultimo = penultima;
            this.tamanho--;
        }
        return elemento;
    }

    @Override
    public T buscar(int posicao) {
        return (T) PegarNo(posicao).getElemento();
    }

    @Override
    public boolean existe(T elemento) {
        No atual = primeiro;
        while (atual != null) {

            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public void limpar() {
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    private No PegarNo(int posicao) {
        No atual = null;
        if ((this.tamanho) / 2 > posicao) {
            atual = primeiro;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            return atual;
        } else {
            atual = ultimo;
            for (int i = tamanho - 1; i > posicao; i--) {
                atual = atual.getAnterior();
            }
            return atual;
        }

    }

    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }
        StringBuilder SB = new StringBuilder("[");
        No atual = this.primeiro;
        for (int i = 0; i < this.tamanho - 1; i++) {
            SB.append(atual.getElemento());
            SB.append(",");
            atual = atual.getProximo();
        }
        SB.append(atual.getElemento());
        SB.append("]");
        return SB.toString();
    }

    public Iterator<T> reverseIterator() {
        return new IteratorReverso<>(this.ultimo);
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    public int indexOf(T elemento) {
        int indice = 0;

        for (No atual = primeiro; atual != null; atual = atual.getProximo()) {
            if (atual.getElemento().equals(elemento)) {
                return indice;
            }
            indice++;
        }
        return indice;

    }

    @Override
    public boolean enfileirar(T valor) {
        this.adicionar(valor);
        return true;
    }

    @Override
    public T desenfileirar() {
        T elemento = this.removerNoInicio();
        return elemento;
    }

    @Override
    public boolean vazia() {
        return this.tamanho == 0;
    }

    @Override
    public T primeiro() {

        return this.primeiro.getElemento();
    }

    @Override
    public T ultimo() {

        return this.ultimo.getElemento();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorDuploEncadeado<>(this.primeiro);
    }

    @Override
    public T Push(T item) {
        this.adicionar(item);
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
        return this.ultimo.getElemento();
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public T PushI(T item) {
        this.adicionarNoInicio(item);
        return item;
    }

    @Override
    public T PopI() {
        T elemento = this.removerNoInicio();
        return elemento;
    }

    @Override
    public T TopI() {
        return this.primeiro.getElemento();
    }
}
