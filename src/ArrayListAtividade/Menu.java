/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListAtividade;

import ArrayList.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aldo
 */
public class Menu {
    
    
    public static void main(String[] args) {
        Scanner Respostas = new Scanner(System.in);
        int resposta = -1;
        String nome ;
        ArrayList<Disciplina> Disciplinas = new ArrayList();
        while(resposta != 0){
            System.out.println("1-Cadastrar Disciplina" + "\n" + "2 - Adicionar Alunos" + "\n" + "3- Listar alunos aprovados em uma disciplina" + "\n" + "4- Listar alunos reprovados em uma disciplina" + "\n" + "5 - Trancar materia" + "\n"
             +"0 - Finalizar programa"
             );
            resposta = Respostas.nextInt();
            
            if(resposta == 1){
                System.out.println("Digite o nome da Disciplina");
                nome = Respostas.next();
                Disciplina D = new Disciplina(nome);
                
                if(Disciplinas.existe(D)){
                    System.out.println("Disciplina ja cadastrada");
                    System.out.println(Disciplinas.toString());
                }else{
                    Disciplinas.adicionar(D);
                }
            
            
            }
            if(resposta == 2){
               
                System.out.println("Digite o nome do aluno");
                String nome1 = Respostas.next();
                System.out.println("Digite a matricula do aluno");
                int matricula = Respostas.nextInt();
                System.out.println("Digite a nota 1 do aluno");
                double nota1 = Respostas.nextDouble();
                System.out.println("Digite a nota 2 do aluno");
                double nota2 = Respostas.nextDouble();
                System.out.println("Digite o nome da disciplina");
                nome = Respostas.next();
                double media = ((nota1 *4) + (nota2 * 6))/10;
                
                Estudantes E = new Estudantes(matricula, nome1, nota1, nota2, media);
                int indice = Disciplinas.indexOf(new Disciplina(nome));
                
                if(Disciplinas.buscar(indice).getListaEstudantes().existe(E) && Disciplinas.existe(new Disciplina(nome))){
                    System.out.println("Aluno ja cadastrado");
                }else{
                    Disciplinas.buscar(indice).adicionarEstudante(E);    
                }
                
            }
            if(resposta == 3){
                System.out.println("Digite o nome da Disciplina: ");
                nome = Respostas.next();
                int indice = Disciplinas.indexOf(new Disciplina(nome));
                System.out.println("Aprovados " + Disciplinas.buscar(indice).retornarAprovados());
            }
            if(resposta == 4){
                System.out.println("Digite o nome da Disciplina: ");
                nome = Respostas.next();
                int indice = Disciplinas.indexOf(new Disciplina(nome));
                System.out.println("Reprovados " + Disciplinas.buscar(indice).retornarReprovados());
            }
            if(resposta == 5){
                System.out.println("Digite o nome da Disciplina do aluno a trancar: ");
                nome = Respostas.next();
                System.out.println("Digite o nome do estudante: ");
                String aluno1 = Respostas.next();
                Estudantes E = new Estudantes(aluno1);
                int indice = Disciplinas.indexOf(new Disciplina(nome));
                Disciplinas.buscar(indice).trancarMateria(E);
            }
        }
    }
}
