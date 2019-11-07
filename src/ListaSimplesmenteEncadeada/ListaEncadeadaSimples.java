/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesmenteEncadeada;

import estruturadedados.Lista;
import java.util.Iterator;

/**
 *
 * @author Aldo
 */
public class ListaEncadeadaSimples<T> implements Lista<T>,Iterable<T> {
    private int tamanho;
    private No primeiro;
    private No ultimo;
    @Override
    public void adicionar(T elemento) {
        adicionarNoFim(elemento);
    }

    @Override
    public void adicionarNoInicio(T elemento) {
        No No = new No(primeiro, elemento);
        this.primeiro = No;
        if(this.tamanho == 0){
            this.ultimo = this.primeiro;
        }
        tamanho++;
    }

    @Override
    public void adicionarNoFim(T elemento) {
        if(tamanho == 0){
            adicionarNoInicio(elemento);
        }else{
            No novo = new No(elemento);
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
            this.tamanho++;
        }
        
    }

    @Override
    public void adicionar(T elemento, int posicao) {
        if(this.tamanho == 0){
            adicionarNoInicio(elemento);
        }else if(posicao == this.tamanho){
            adicionarNoFim(elemento);
        }
        else{
            No anterior = this.pegarNo(posicao - 1);
            No novo = new No(anterior.getProximo(), elemento);
            anterior.setProximo(novo);
            this.tamanho++;
        }
    }

    @Override
    public T remover(int posicao) {
        T elemento = null;
        if(!this.posiçãoOcupada(posicao)){
            throw new IllegalArgumentException("Nao existe posicao");
        
        }
        if(posicao == 0){
            this.removerNoInicio();
        }else if(posicao == tamanho){
            this.removerNoFim();
        }else{
            No anterior = this.pegarNo(posicao - 1);
            No atual = anterior.getProximo();
            elemento = (T) atual.getElemento();
            No proxima = atual.getProximo();
            anterior.setProximo(proxima);
            this.tamanho--;
            
        }
    return elemento;
    }

    @Override
    public T removerNoInicio() {
        if(!this.posiçãoOcupada(0)){
            throw new IllegalArgumentException("Nao existe nada para remover");
        }
        T primeirinho = (T) primeiro.getElemento();
        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
        if(this.tamanho == 0){
            this.ultimo = null;
        }
        return primeirinho;
    }

    @Override
    public T removerNoFim() {
        if(!this.posiçãoOcupada(this.tamanho - 1)){
            throw new IllegalArgumentException("Nao existe antecessor");}
        
        No penultimo = this.pegarNo(tamanho - 2);
        penultimo.setProximo(null);
        T elemento = (T) this.ultimo.getElemento();
        this.ultimo = penultimo;
        this.tamanho --;
        return elemento;
    }

    @Override
    public T buscar(int posicao) {
        return (T) this.pegarNo(posicao).getElemento();
    }

    @Override
    public boolean existe(T elemento) {
        No atual = primeiro;
        while(atual != null){
            
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public void limpar() {
       //duvida
    }
    //Pegar o No
    private No pegarNo(int posiçao){
        if(!this.posiçãoOcupada(posiçao)){
            throw new IllegalArgumentException("Posicao nao existe");
        }
        No atual = this.primeiro;
     
        for (int i = 0; i < posiçao; i++) {
            atual = atual.getProximo();
        }
     return atual;
    }
    private boolean posiçãoOcupada(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }
    public int indexOf(T elemento) {
        
        int indice = 0;
        for (No atual = primeiro; atual != null ; atual = atual.getProximo()) {
            if(atual.getElemento().equals(elemento)){
                return indice;
            }indice++;
        }
        return indice;
    }
    //Retornar o tamanho
    public int tamanho(){
        return tamanho;
    }
   
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder SB = new StringBuilder("[");
        No atual = primeiro;
        for (int i = 0; i < tamanho - 1; i++) {
            SB.append(atual.getElemento());
            SB.append(", ");
            atual = atual.getProximo();
        }
        SB.append(atual.getElemento());
        SB.append("]");
        return SB.toString();
    }

    @Override
    public Iterator<T> iterator() {
       return new IteratorEncadeado(this.primeiro);
    }
    
}
