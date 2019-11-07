
package ArrayList;

import estruturadedados.Fila;
import estruturadedados.Pilha;

public class teste {
    public static void main(String[] args) {
        Pilha<Integer> p = new ArrayList<>();
        p.Push(2);
        p.Push(3);
        p.Pop();
        System.out.println(p.size());
        System.out.println(p.Top());
        System.out.println(p);
    }
}