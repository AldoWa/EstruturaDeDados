/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesmenteEncadeada;

import java.util.LinkedList;

/**
 *
 * @author Aldo
 */
public class Testes {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Integer> LES = new ListaEncadeadaSimples<>();
        LES.adicionar(1);
        LES.adicionar(2);
        System.out.println(LES);    
      
        for (Integer i : LES){
            System.out.println(i);
        }
    }
}
