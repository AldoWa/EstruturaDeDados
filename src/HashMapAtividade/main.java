/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package HashMapAtividade;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        while(contador != -1){
            System.out.println("1 - Cadastrar Turma\n" + "2 - Cadastrar Aluno\n"+ "3 - Matricular aluno\n" + "4 - Desmatricular aluno\n" + "5 - Excluir turma\n" + "6 - Listar Alunos da turma\n" + "7 - Listar todas as turmas cadastradas\n"+ "-1- Parar programa" );
            int reposta = Integer.parseInt(scanner.nextLine());
            switch (reposta) {
                case 1:
                    System.out.println("Digite o codigo da turma : ");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite o tamanho da turma : ");
                    int tamanho = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite o nome da turma: ");
                    String nome = scanner.nextLine();
                    bd.cadastrarTurma(codigo, tamanho, nome);
                    break;
                case 2:
                    System.out.println("Digite o RG do aluno: ");
                    String RG = scanner.nextLine();
                    System.out.println("Digite o nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    bd.cadastrarAluno(RG, nomeAluno);
                    break;
                case 3:
                    System.out.println("Digite o codigo da turma que deseja cadastrar o aluno: ");
                    String codigoCadastro = scanner.nextLine();
                    System.out.println("Digite o RG do aluno para cadastrar na turma: ");
                    String rgCadastro = scanner.nextLine();
                    bd.matricularTurma(codigoCadastro, rgCadastro);
                case 4:
                    System.out.println("Digite o codigo da turma que deseja desmatricular o aluno: ");
                    String codigodesCadastro = scanner.nextLine();
                    System.out.println("Digite o RG do aluno para desmatricular na turma: ");
                    String rgdesCadastro = scanner.nextLine();
                    bd.desMatricularDaTurma(codigodesCadastro, rgdesCadastro);
                case 5:
                    System.out.println("Digite o codigo da turma que deseja excluir: ");
                    String codigoExclusao = scanner.nextLine();
                    bd.tirarTurma(codigoExclusao);
                case 6:
                    System.out.println("Digite o codigo da turma para mostrar os alunos: ");
                    String codigoTurmaAlunos = scanner.nextLine();
                    bd.listarAlunosDeUmaTurma(codigoTurmaAlunos);
                case 7:
                    System.out.println("Turmas cadastradas");
                    bd.ListarTurmas();
                case -1:
                    contador = -1;
                    break;
            }
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //CadastrarTurma
        bd.cadastrarTurma("123", 3, "CC");
        bd.cadastrarTurma("300", 1, "BancoDeDados");
        //CadastrarAluno
        bd.cadastrarAluno("030", "Aldo");
        bd.cadastrarAluno("031", "Bianca");
        bd.cadastrarAluno("032", "Matheus");
        //MatricularAlunoNaTurma
        bd.matricularTurma("123", "030");
         bd.matricularTurma("300", "031");
          bd.matricularTurma("123", "032");
        //CancelarMatricula
        bd.desMatricularDaTurma("123", "030");
        //CancelarTurma
        bd.tirarTurma("123");
        //Listar alunos de uma turma
        bd.listarAlunosDeUmaTurma("300");
        //ListarTurma
          bd.ListarTurmas();
        
       
    }
}
