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
public class Pessoa {
    private String codigo;
    private String nome;
    private ListaEncadeadaDupla<Bem> LDE = new ListaEncadeadaDupla<>();

    public Pessoa(String codigo) {
        this.codigo = codigo;
    }

    

    public Pessoa() {
    }

    public Pessoa(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public void incluirBem(Bem bem){
        LDE.adicionar(bem);
    }
    public void removerBem(Bem bem){
        int indice = LDE.indexOf(bem);
        LDE.remover(indice);
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ListaEncadeadaDupla<Bem> getLDE() {
        return LDE;
    }

    public void setLDE(ListaEncadeadaDupla<Bem> LDE) {
        this.LDE = LDE;
    }
    public boolean equals(Object obj) 
    { 
          
    
    if(this == obj) {
            return true; 
    }
       
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false; 
        }
       
        Pessoa Pessoa = (Pessoa) obj; 
        
        return (Pessoa.codigo.equals(this.codigo)); 
    }

    @Override
    public String toString() {
            
            StringBuilder SB = new StringBuilder();       
            SB.append("Pessoa-" + "Codigo = " + codigo + " Nome = " + nome + " Bens =" + LDE );
           
       
        return SB.toString();
    }

  
    

    
        
    
}
