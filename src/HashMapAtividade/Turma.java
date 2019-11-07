/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package HashMapAtividade;

import ArrayList.ArrayList;
import ListaDuplamenteEncadeada.ListaEncadeadaDupla;
import estruturadedados.Fila;
import java.util.Objects;
import java.util.Scanner;

public class Turma {
          private ArrayList<Aluno> alunos;
          private Fila<Aluno> espera;
          private String codigoTurma;
          private int quantidade;
          private String nome;
          
    public Turma() {
        this.alunos = new ArrayList<>();
        this.espera = new ListaEncadeadaDupla<>();
      
    }

    public Turma(String codigoTurma, int quantidade ,  String nome) {
        this.alunos = new ArrayList<>();
        this.espera = new ListaEncadeadaDupla<>();
        this.codigoTurma = codigoTurma;
        this.quantidade = quantidade;
        this.nome = nome;
    }
    
    public void matricular(Aluno aluno){
        Scanner scan = new Scanner(System.in);
        if(getQuantidade() > this.alunos.tamanho()){
            this.alunos.adicionar(aluno);
        }else{
            System.out.println("Turma cheia, Deseja entrar na fila de espera(0-N;1-S) ? ");
            int resposta = scan.nextInt();
            switch(resposta){
                case 0:
                    System.out.println("Reserva nao feita");
                    break;
                case 1:
                    this.espera.enfileirar(aluno);
                    System.out.println("Reserva feita");
                    break;
            }
        }
    }
    
    public void desMatricular(Aluno aluno){
        Boolean existe = this.alunos.existe(aluno);
        if(existe){
            int indice = this.alunos.indexOf(aluno);
          
            this.alunos.remover(indice);
            if(this.espera.tamanho() > 0){
                Aluno alunoEspera = this.espera.desenfileirar();
                this.alunos.adicionar(alunoEspera);
            }
            
        }else{
            System.out.println("Não existe esse aluno na Turma.");
        }
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Fila<Aluno> getEspera() {
        return espera;
    }

    public void setEspera(Fila<Aluno> espera) {
        this.espera = espera;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Turma--"+ nome + " Alunos = " + alunos + "Lista De Espera = " + espera +  " Quantidade Total Da Turma = " + quantidade  + "";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigoTurma);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.codigoTurma, other.codigoTurma)) {
            return false;
        }
        return true;
    }
          
}
