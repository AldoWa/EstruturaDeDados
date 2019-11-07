/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeadaAtividade;
import ListaDuplamenteEncadeada.ListaEncadeadaDupla;
import java.util.Scanner;

/**
 *
 * @author Aldo
 */
public class main {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int resposta = -1;
        int contador = 0;
        ListaEncadeadaDupla<Pessoa> Pessoas = new ListaEncadeadaDupla<Pessoa>();
        while(resposta != 0){
            if(contador == 0){
                System.out.println("Bem vindo!");
                contador = 1;
            }
            System.out.println("1 - Incluir pessoa" + "\n" + "2 - Excluir Pessoa" + "\n" + "3 - Consultar pessoa" + "\n" + "4 - Listar Pessoas" + "\n" + "5 - Cadastrar Bem" + "\n" + "6 - Remover Bem");
            resposta = S.nextInt();
            if(resposta == 1){
                String nome;
                String codigo;
                System.out.println("Digite seu nome: ");
                nome = S.next();
                System.out.println("Digite seu codigo:");
                codigo = S.next();
                
                Pessoa P = new Pessoa(codigo, nome);
                if(Pessoas.existe(P)){
                    System.out.println("Codigo de Pessoa ja cadastrado!");
                }else{
                    Pessoas.adicionar(P);
                    System.out.println(Pessoas);
                }
            }if(resposta == 2){
                String codigo;
                System.out.println("Digite o codigo da pessoa para excluir: ");
                codigo = S.next();
                if(!Pessoas.existe(new Pessoa(codigo))){
                    System.out.println("Nao existe pessoa com esse codigo");   
                }else{
                    int indice = Pessoas.indexOf(new Pessoa(codigo));
                    Pessoas.remover(indice);
                    System.out.println("Pessoa removida");
                }
            }if(resposta == 3){
                String codigo;
                System.out.println("Digite o codigo da pessoa para ver: ");
                codigo = S.next();
                if(!Pessoas.existe(new Pessoa(codigo))){
                    System.out.println("Nao existe pessoa com esse codigo");
                }else{
                    int indice = Pessoas.indexOf(new Pessoa(codigo));
                    System.out.println(Pessoas.buscar(indice));
                }
            }
            if(resposta == 5){
                System.out.println("Codigo da pessoa para adicionar o bem");
                String codigo = S.next();
                if(!Pessoas.existe(new Pessoa(codigo))){
                    System.out.println("Nao existe essa pessoa");   
                }else{
                    Bem B;
                    B = new Bem();
                    System.out.println("Digite o nome do Bem: ");
                    B.setNomedobem(S.next());
                    System.out.println("Digite o codigo do Bem: ");
                    B.setCodigodobem(S.next());
                    
                    
                    System.out.println("Digite o Valor do Bem: ");
                    B.setValordobem(S.nextDouble());
                    B = new Bem(B.getCodigodobem(), B.getNomedobem(), B.getValordobem());
                      int indice = Pessoas.indexOf(new Pessoa(codigo));
                    if(Pessoas.buscar(indice).getLDE().existe(B)){
                        System.out.println("Produto ja cadastrado");
                    }else{
                         Pessoas.buscar(indice).incluirBem(B);
                    }
                  
                   
                }    
            }if(resposta == 6){
                System.out.println("Codigo da pessoa para remover o bem:");
                String codigo = S.next();
                if(!Pessoas.existe(new Pessoa(codigo))){
                    System.out.println("Nao existe essa pessoa");
                }else{
                    Bem B;
                    B = new Bem();
                    System.out.println("Digite o codigo para remover o bem");
                    String codigoB = S.next();
                    int indice = Pessoas.indexOf(new Pessoa(codigo));
                    
                    
                        Pessoas.buscar(indice).removerBem(new Bem(codigoB));
                    
                    
                    
                }
            }
            if(resposta ==4){
                    System.out.println(Pessoas);
                }
        }
    }
}
