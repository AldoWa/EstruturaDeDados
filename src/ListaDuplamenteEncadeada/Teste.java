/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

import estruturadedados.Fila;
import estruturadedados.Pilha;
import estruturadedados.PilhaAoContrario;



/**
 *
 * @author Aldo
 */
public class Teste {
    public static void main(String[] args) {
        ListaEncadeadaDupla LD = new ListaEncadeadaDupla();
        LD.adicionar(1);
         LD.adicionar(2);
          LD.adicionar(3);
           LD.adicionar(4);
            LD.adicionar(5);
             LD.adicionar(6);
             System.out.println(LD);
             
             System.out.println(LD.remover(0));
             System.out.println(LD);
             System.out.println(LD.tamanho());
        }
    }

