/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package HashMapAtividade;

import Hashmap.Hashmap;

public class BancoDeDados {
    
    private Hashmap<String, Turma> turmas = new Hashmap<>();
    private Hashmap<String, Aluno> alunos = new Hashmap<>();
    
    public void cadastrarTurma(String codigo, int quantidade, String nome) {
        if (turmas.existe(codigo)) {
            System.out.println("Codigo de turma ja cadastrado, nao pode ter duas turmas com o mesmo codigo");
        } else {
            Turma turma = new Turma(codigo, quantidade, nome);
            turmas.inserir(codigo, turma);
        }
        
    }
    
    public void matricularTurma(String codigo, String RG) {
        if(turmas.existe(codigo)){
            Turma turma = turmas.obter(codigo);
            Aluno aluno = retornarAluno(RG);
        
        
        
        if (aluno == null) {
            System.out.println("Nao existe aluno para cadastrar na turma");
        } else {
            turma.matricular(aluno);
        }
        }else{
            System.out.println("Turma nao existe");
        }
        
        
    }
    
    public void desMatricularTurma(String codigo, String RG) {
        Turma turma = this.turmas.obter(codigo);
        Aluno aluno = retornarAluno(RG);
        if (aluno == null) {
            System.out.println("Nao existe aluno para desmatricular na turma");
        } else {
            turma.desMatricular(aluno);
        }
    }
    
    public Aluno retornarAluno(String rg) {
        if (alunos.existe(rg)) {
            return alunos.obter(rg);
        }
        return null;
    }
    
    public void cadastrarAluno(String RG, String nome) {
        if (alunos.existe(RG)) {
            System.out.println("RG ja cadastrado");
        } else {
            Aluno aluno = new Aluno(RG, nome);
            alunos.inserir(RG, aluno);
        }
        
    }

    public void listarAlunosDeUmaTurma(String codigo){
        if(turmas.existe(codigo)){
            Turma turma = turmas.obter(codigo);
            System.out.println(turma);
        }else{
            System.out.println("Turma nao existe");
        }
    } 
    
    public void ListarTurmas() {
        System.out.println(turmas);
    }
}
