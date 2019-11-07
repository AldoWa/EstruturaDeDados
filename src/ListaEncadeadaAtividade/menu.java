/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeadaAtividade;

import ListaSimplesmenteEncadeada.ListaEncadeadaSimples;
import java.util.Scanner;

/**
 *
 * @author Aldo
 */
public class menu {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Produto> Produtos = new ListaEncadeadaSimples<>();
        Scanner resposta = new Scanner(System.in);
        int soma = 0;
        int contador = -1;
        while(contador != 0){
            System.out.println("1- Cadastrar Produto" + "\n" + "2- Registrar Compra" + "\n" + "3- Registrar Venda" + "\n" + "4- Mostrar compras" + "\n" + "5- Mostrar Vendas");
            contador = resposta.nextInt();
            if(contador == 1){
                
                System.out.println("Nome do produto");
                String nome = resposta.next();
                System.out.println("Codigo do produto");
                int Codigo = resposta.nextInt();
              
                
                resposta.nextLine();
                Produto P = new Produto(Codigo, nome);
            
                    
            
                     Produtos.adicionar(P);
                     System.out.println(Produtos);
                
               
            
            }if(contador == 2){
                
                System.out.println("Digite o nome do produto para registrar sua compra");
                String nomeproduto = resposta.next();
                int indice = Produtos.indexOf(new Produto(nomeproduto));
                if(Produtos.existe(new Produto(nomeproduto))){
                System.out.println("Data de compra(dd/MM/YYYY) : ");
                String data = resposta.next();
                System.out.println("Quantidade: ");
                int qtd = resposta.nextInt();
                
                soma = soma + qtd;
                    System.out.println("Valor total da compra");
                double total = resposta.nextInt();
                Produtos.buscar(indice).setQuantidade(soma);
                if(Produtos.buscar(indice).getCustounitario() == 0){
                    Produtos.buscar(indice).setCustounitario(total/qtd);
                }
                Compra C = new Compra(data,qtd,total);
                
                    System.out.println("Compra cadastrada com sucesso");
                    Produtos.buscar(indice).adicionarCompra(C);
                    
                }else{
                    System.out.println("Produto nao cadastrado");
                }
                
            }
            if(contador == 3){
                System.out.println("Digite o nome do produto para cadastrar a venda: ");
                String nomeproduto = resposta.next();
                int indice = Produtos.indexOf(new Produto(nomeproduto));
                if(Produtos.existe(new Produto(nomeproduto))){
                    System.out.println("Data da venda: ");
                    String data = resposta.next();
                    System.out.println("Quantidade da venda:");
                    
                    int qtdv = resposta.nextInt();
                    
                    if(Produtos.buscar(indice).getQuantidade() >= qtdv){
                    
                        Produtos.buscar(indice).setQuantidade(Produtos.buscar(indice).getQuantidade() - qtdv); 
                        double custouni = (Produtos.buscar(indice).getCustounitario());
                        double valortotalvenda = (Produtos.buscar(indice).getQuantidade()*Produtos.buscar(indice).getCustounitario());
                        System.out.println("Custo unitario da venda" + custouni);
                        System.out.println("Valor total - " + valortotalvenda);
                        Venda V = new Venda(data, qtdv, valortotalvenda, custouni);
                        
                            
                            System.out.println("Venda Cadastrada com sucesso");
                            Produtos.buscar(indice).adicionarVenda(V);
                        
                    }else{
                        System.out.println("Produto sem quantidade suficiente");
                        continue;
                    }
                    
                }else{
                    System.out.println("Produto ainda não cadastrado");
                }
            }if(contador == 4){
                
                System.out.println("Digite o nome do produto para verificar todas as compras");
                String nome = resposta.next();
                int indice = Produtos.indexOf(new Produto(nome));
                if(Produtos.existe(new Produto(nome))){
                    if(Produtos.buscar(indice).getListaCompra().tamanho() != 0){
                        Produtos.buscar(indice).retornarCompra();
                    }else{
                        System.out.println("Nao a compras cadastradas ainda");
                    }
                }else{
                    System.out.println("Produto nao cadastrado");
                }
            }if(contador == 5){
                
                System.out.println("Digite o nome do produto para verificar todas as vendas");
                String nome = resposta.next();
                int indice = Produtos.indexOf(new Produto(nome));
                if(Produtos.existe(new Produto(nome))){
                    if(Produtos.buscar(indice).getListaVenda().tamanho() != 0){
                        Produtos.buscar(indice).retornarVendas();
                    }else{
                        System.out.println("Nao a vendas cadastradas ainda");
                    }
                }else{
                    System.out.println("Produto nao cadastrado");
                }
            }
        }
        
    }
}
