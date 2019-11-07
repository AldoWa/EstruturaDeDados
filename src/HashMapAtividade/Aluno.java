/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package HashMapAtividade;

import java.util.Objects;

public class Aluno {
           private String rg;
           private String nome;

    public Aluno(String rg, String nome) {
        this.rg = rg;
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rg);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno - " + "RG=" + rg + "/ Nome=" + nome + "";
    }
           
}
