/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package FilaAtividade;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        BancoDeDados BD = new BancoDeDados();
//        BD.cadastrarProduto(1, "PS4", 4000.0);
//        BD.cadastrarCliente("Rua Jose Mesquita neto", 2, "Aldo");
//        BD.cadastrarCliente("Farolandia", 3, "Matheus");
//        BD.cadastrarProduto(2, "Vorde", 2.0);
//        BD.cadastrarProduto(3, "Ps5", 10000.000);
//        BD.efetuarPedido(1);
//        BD.efetuarPedido(2);
//        BD.efetuarPedido(3);
//        BD.despecharPedido("Aldo");
//        
//        
//        BD.produtosPedidos();

    Scanner resposta = new Scanner(System.in);
    int conteudo = 0;
    while(conteudo != -1){
        System.out.println("1- Cadastrar Produto\n" + "2- Cadastrar Cliente\n" + "3- Efetuar pedido\n" + "4- Despechar pedido\n" +"5- Exibir fila de pedidos\n" + "6- Exibir produtos cadastrados\n" + "-1- Parar Programa");
        conteudo = resposta.nextInt();
        resposta.nextLine();
        switch(conteudo){
            case 1:
                System.out.println("Codigo do produto: ");
                int cod_Produto = resposta.nextInt();
                resposta.nextLine();
                System.out.println("Nome do produto: ");
                String nome = resposta.nextLine();
                System.out.println("Preco do produto: ");
                Double preco = resposta.nextDouble();
                BD.cadastrarProduto( cod_Produto,  nome,  preco);
                System.out.println("Conteudo cadastrado >>>>>");
                break;
            case 2:
                System.out.println("Nome do cliente: ");
                String nomeCliente = resposta.nextLine();
                
                System.out.println("ID do cliente: ");
                int clientID = resposta.nextInt();
                resposta.nextLine();
                System.out.println("Endereco do cliente: ");
                String endereco = resposta.nextLine();
                BD.cadastrarCliente( endereco,  clientID,  nomeCliente);
                break;
            case 3:
                System.out.println("Digite o codigo do Produto para fazer o pedido: ");
                int cod_ProdutoP = resposta.nextInt();
                BD.efetuarPedido(cod_ProdutoP);
                break;
            case 4:
                System.out.println("Digite o nome para despachar o pedido");
                String nomeParaDespecho = resposta.nextLine();
                BD.despecharPedido(nomeParaDespecho);    
                break;
            case 5:
                BD.produtosPedidos();
                break;
            case 6:
                BD.retornarProdutosCadastrados();
                break;
            case -1:
                break;
        }
    }
    }
}
