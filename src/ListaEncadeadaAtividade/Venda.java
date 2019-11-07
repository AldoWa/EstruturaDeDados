/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeadaAtividade;

/**
 *
 * @author Aldo
 */
public class Venda {
    private String datavenda;
    private int qtd;
    private double totaldavenda;
    private double preçounitariodavenda;

    public Venda(String datavenda, int qtd, double totaldavenda, double preçounitariodavenda) {
        this.datavenda = datavenda;
        this.qtd = qtd;
        this.totaldavenda = totaldavenda;
        this.preçounitariodavenda = preçounitariodavenda;
    }
    

    public String getDatacompra() {
        return datavenda;
    }

    public void setDatacompra(String datacompra) {
        this.datavenda = datacompra;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotaldavenda() {
        return totaldavenda;
    }

    public void setTotaldavenda(double totaldavenda) {
        this.totaldavenda = totaldavenda;
    }
    
}
