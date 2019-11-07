/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListAtividade;

import ArrayList.ArrayList;

/**
 *
 * @author Aldo
 */
public class Disciplina {
    private String nome;
    private ArrayList<Estudantes> ListaEstudantes = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
    }
    
    public void adicionarEstudante(Estudantes E){
        this.ListaEstudantes.adicionar(E);
    }
    public String retornarAprovados(){
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < ListaEstudantes.tamanho(); i++) {
            if(ListaEstudantes.buscar(i).getMedia() >= 6){
               SB.append(ListaEstudantes.buscar(i).getNome()).append(ListaEstudantes.buscar(i).getNota1()).append(ListaEstudantes.buscar(i).getNota2());
               
            }
        }
        return SB.toString();
    }
   public String retornarReprovados(){
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < ListaEstudantes.tamanho(); i++) {
            if(ListaEstudantes.buscar(i).getMedia() < 6){
               SB.append(ListaEstudantes.buscar(i).getNome()).append(ListaEstudantes.buscar(i).getNota1()).append(ListaEstudantes.buscar(i).getNota2());
               
            }
        }
        return SB.toString();
    }
   public void trancarMateria(Estudantes E){
       int remover = ListaEstudantes.indexOf(E);
       if(ListaEstudantes.existe(E)){
           ListaEstudantes.remover(remover);
           
       }else{
           System.out.println("Aluno nao existe");
       }
   }
    public boolean equals(Object obj) 
    { 
          
    
    if(this == obj) 
            return true; 
          
       
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
       
        Disciplina Disciplina = (Disciplina) obj; 
        
        return (Disciplina.nome.equals(this.nome)); 
    } 

    public ArrayList<Estudantes> getListaEstudantes() {
        return ListaEstudantes;
    }

    public void setListaEstudantes(ArrayList<Estudantes> ListaEstudantes) {
        this.ListaEstudantes = ListaEstudantes;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", ListaEstudantes=" + ListaEstudantes + '}';
    }
      
}
