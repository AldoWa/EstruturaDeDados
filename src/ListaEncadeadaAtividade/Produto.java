/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeadaAtividade;

import ListaSimplesmenteEncadeada.ListaEncadeadaSimples;
import java.util.Date;

/**
 *
 * @author Aldo
 */
public class Produto {
    private int codigodoproduto;
    private String nomedoproduto;
    private double custounitario = 0;
    private int quantidade = 0;
    private ListaEncadeadaSimples<Compra> ListaCompra = new ListaEncadeadaSimples<>();
    private ListaEncadeadaSimples<Venda> ListaVenda = new ListaEncadeadaSimples<>();
    public Produto(int codigodoproduto, String nomedoproduto) {
        this.codigodoproduto = codigodoproduto;
        this.nomedoproduto = nomedoproduto;
            
    
    }
    public void retornarCompra(){
        System.out.println(ListaCompra.toString());
    }
    public void retornarVendas(){
        System.out.println(ListaVenda.toString());
    }
    public Produto(String nomedoproduto) {
        this.nomedoproduto = nomedoproduto;
    }
    public void adicionarCompra(Compra elemento){
        this.ListaCompra.adicionar(elemento);
    }
    public void adicionarVenda(Venda elemento){
        this.ListaVenda.adicionar(elemento);
    }
    public int getCodigodoproduto() {
        return codigodoproduto;
    }

    public void setCodigodoproduto(int codigodoproduto) {
        this.codigodoproduto = codigodoproduto;
    }

    public String getNomedoproduto() {
        return nomedoproduto;
    }

    public void setNomedoproduto(String nomedoproduto) {
        this.nomedoproduto = nomedoproduto;
    }

    public double getCustounitario() {
        return custounitario;
    }

    public void setCustounitario(double custounitario) {
        this.custounitario = custounitario;
    }

    public ListaEncadeadaSimples<Compra> getListaCompra() {
        return ListaCompra;
    }

    public void setListaCompra(ListaEncadeadaSimples<Compra> ListaCompra) {
        this.ListaCompra = ListaCompra;
    }

    public ListaEncadeadaSimples<Venda> getListaVenda() {
        return ListaVenda;
    }

    public void setListaVenda(ListaEncadeadaSimples<Venda> ListaVenda) {
        this.ListaVenda = ListaVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
     public boolean equals(Object obj) 
    { 
          
    
    if(this == obj) {
            return true; 
    }
       
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false; 
        }
       
        Produto Produto = (Produto) obj; 
        
        return (Produto.nomedoproduto.equals(this.nomedoproduto)); 
    }
    @Override
    public String toString() {
        return "Produto{" + "Codigo" + codigodoproduto + ", Nome=" + nomedoproduto + ", CustoUnitario=" + custounitario + ", Quantidade=" + quantidade + ", Compras=" + ListaCompra + ", Vendas=" + ListaVenda + '}';
    }
    
}
