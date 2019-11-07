/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package Hashmap;

import java.util.Objects;

public class NoHash<K,V> {
      private K chave;
      private V valor;
      private NoHash<K,V> proximo;

    public NoHash() {
    }

    public NoHash(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public NoHash(K chave, V valor, NoHash<K, V> proximo) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = proximo;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public NoHash<K, V> getProximo() {
        return proximo;
    }

    public void setProximo(NoHash<K, V> proximo) {
        this.proximo = proximo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NoHash<?, ?> other = (NoHash<?, ?>) obj;
        if (!Objects.equals(this.chave, other.chave)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.proximo, other.proximo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + "Chave " + chave + " = " + valor  + "";
    }
      
}
