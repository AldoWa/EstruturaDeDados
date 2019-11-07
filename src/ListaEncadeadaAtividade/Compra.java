/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeadaAtividade;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aldo
 */
public class Compra {
    private String datacompra;
    private int qtd;
    private double total;

    public Compra(String datacompra, int qtd, double total) {
        this.datacompra = datacompra;
        this.qtd = qtd;
        this.total = total;
    }
    

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }
    
    

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compra - " + "DataCompra=" + datacompra + ", QuantidadeComprada=" + qtd + ", Total=" + total + '}';
    }

    
    
}
