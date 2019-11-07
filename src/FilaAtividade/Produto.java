/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package FilaAtividade;

public class Produto {
      private int cod_Produto;
      private String nome;
      private Double preco;

    public Produto() {
    }

    public Produto(int cod_Produto, String nome, Double preco) {
        this.cod_Produto = cod_Produto;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCod_Produto() {
        return cod_Produto;
    }

    public void setCod_Produto(int cod_Produto) {
        this.cod_Produto = cod_Produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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
        final Produto other = (Produto) obj;
        if (this.cod_Produto != other.cod_Produto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto = " + "cod_Produto=" + cod_Produto + ", nome=" + nome + ", preco=" + preco + '-';
    }
      
}
