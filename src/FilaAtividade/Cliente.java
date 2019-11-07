/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package FilaAtividade;

import ArrayList.ArrayList;
import java.util.Objects;

public class Cliente {
      private String endereco;
      private int clienteID;
      private String nome;
      private ArrayList<Produto> produtos = new ArrayList<Produto>();
    public Cliente() {
    }

    public Cliente(String endereco, int clienteID, String nome) {
        this.endereco = endereco;
        this.clienteID = clienteID;
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void adicionarProduto(Produto produto){
        if(checarSeJaExiste(produto) == true){
            System.out.println("Ja existe");
        }else{
            this.produtos.adicionar(produto);
        }
    }
    public boolean checarSeJaExiste(Produto produto){
        for(Produto P: produtos){
            if(P.equals(produto)){
                return true;
            }
        }
        return false;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
      
}
