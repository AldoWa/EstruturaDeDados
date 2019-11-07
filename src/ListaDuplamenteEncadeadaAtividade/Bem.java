/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeadaAtividade;

/**
 *
 * @author Aldo
 */
public class Bem {
    private String codigodobem;
    private String nomedobem;
    private double valordobem;

    public Bem() {
    }

    public Bem(String codigodobem) {
        this.codigodobem = codigodobem;
    }

    public Bem(String codigodobem, String nomedobem, double valordobem) {
        this.codigodobem = codigodobem;
        this.nomedobem = nomedobem;
        this.valordobem = valordobem;
    }

    public String getCodigodobem() {
        return codigodobem;
    }

    public void setCodigodobem(String codigodobem) {
        this.codigodobem = codigodobem;
    }

    public String getNomedobem() {
        return nomedobem;
    }

    public void setNomedobem(String nomedobem) {
        this.nomedobem = nomedobem;
    }

    public double getValordobem() {
        return valordobem;
    }

    public void setValordobem(double valordobem) {
        this.valordobem = valordobem;
    }
public boolean equals(Object obj) 
    { 
          
    
    if(this == obj) {
            return true; 
    }
       
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false; 
        }
       
        Bem Bem = (Bem) obj; 
        
        return (Bem.codigodobem.equals(this.codigodobem)); 
    }
    @Override
    public String toString() {
         StringBuilder SB = new StringBuilder();       
            SB.append("[ Bem- " + "Codigo do bem = " + codigodobem + " Nome do bem  = " + nomedobem + " Valor do bem =" + valordobem + " ]" );
        return SB.toString();
    }
    
}
