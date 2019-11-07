
import Hashmap.Hashmap;

import java.util.HashMap;


/**
 *
 * @author Aldo Wanderley Costa Junior
 */


public class teste {
    public static void main(String[] args) {
      
       Hashmap<
               Integer, Integer> h1 = new Hashmap<>();
       
       h1.limpar();
        System.out.println(h1);
        h1.inserir(1, 123);
        h1.inserir(5, 123);
        h1.inserir(9, 123);
        h1.inserir(11, 123);
        h1.inserir(12, 123);
        
        
       
    }
}
