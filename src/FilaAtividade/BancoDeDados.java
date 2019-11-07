/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package FilaAtividade;

import ArrayList.ArrayList;
import ListaDuplamenteEncadeada.ListaEncadeadaDupla;
import estruturadedados.Fila;

public class BancoDeDados {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private Fila<Produto> enFilerar = new ListaEncadeadaDupla<Produto>();
    private Fila<Cliente> clienteFila = new ListaEncadeadaDupla<>();

    public void cadastrarProduto(int codigo, String nome, double preco) {
        Produto produto = new Produto(codigo, nome, preco);
        if (checarseExisteProduto(codigo) == true) {
            System.out.println("Produto ja existe");
        } else {
            produtos.adicionar(produto);
        }

    }

    public void cadastrarCliente(String endereco, int clienteID, String nome) {
        Cliente cliente = new Cliente(endereco, clienteID, nome);
        if (checarseExisteCliente(nome) == true) {
            System.out.println("Cliente ja cadastrado");
        } else {
            this.clienteFila.enfileirar(cliente);
        }
    }

    public void efetuarPedido(int codigo) {
        if (this.checarseExisteProduto(codigo) == true) {
            this.enFilerar.enfileirar(this.acharProduto(codigo));
            System.out.println("Produto foi colocado na fila com sucesso");
        } else {
            System.out.println("Produto nao existe");
        }
    }

    public Produto despecharPedido(String nome) {
        Produto primeiro = null;
        if (vazio() == false) {
            primeiro = enFilerar.primeiro();
            if (checarseExisteCliente(nome) == true) {
                for (Cliente c : this.clienteFila) {

                    if (c.getNome().equals(nome)) {
                        c.getProdutos().adicionar(primeiro);
                        System.out.println("Produto" + primeiro + "Despechado para " + c.getNome() + " Endereco: " + c.getEndereco());

                        enFilerar.desenfileirar();

                    }

                }
            } else {
                System.out.println("Pessoa nao existe");
            }
        } else {
            System.out.println("A fila de envios esta vazia");
        }

        return primeiro;
    }

    private boolean vazio() {
        if (enFilerar.vazia() == true) {
            return true;
        }
        return false;
    }
    private boolean vazioCadastrado(){
        if (this.produtos.tamanho() == 0) {
            return true;
        }
        return false;
    }
    private boolean checarseExisteCliente(String nome) {
        for (Cliente cliente : this.clienteFila) {
            if (cliente.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    private boolean checarseExisteProduto(int cod) {
        for (Produto p : this.produtos) {
            if (p.getCod_Produto() == cod) {
                return true;
            }
        }
        return false;
    }

    private Produto acharProduto(int cod) {
        for (Produto produto : this.produtos) {
            if (produto.getCod_Produto() == cod) {
                return produto;
            }
        }
        return null;
    }

    public void produtosPedidos() {
        if(this.vazio() == true){
            System.out.println("Nenhum produto ainda foi pedido");
        }else{
            System.out.println(enFilerar);
        }
    }

    public void retornarProdutosCadastrados() {
       if(this.vazioCadastrado() == true){
           System.out.println("Nenhum produto cadastrado");
       }else{
           System.out.println(produtos);
       }
    }
}
