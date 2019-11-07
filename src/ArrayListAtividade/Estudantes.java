/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListAtividade;

/**
 *
 * @author Aldo
 */
public class Estudantes {
    private int matricula;
    private String nome;
    private double nota1;
    private double nota2;
    private double media;

    
    public Estudantes(String nome) {
        this.nome = nome;
    }
    public Estudantes(int matricula, String nome, double nota1, double nota2, double media) {
        this(nome);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }


    public double getMedia() {
        return media;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
public boolean equals(Object obj) 
    { 
          
  
    if(this == obj)
            return true; 
          
       
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
      
        Estudantes Estudantes = (Estudantes) obj; 
          
        
        return (Estudantes.nome.equals(this.nome)); 
    } 
    
}
