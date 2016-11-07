/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 631510046
 */
public class Venda {
    private static int count = 1;
    private final int id;
    private final Date data_venda;
    private final Usuario comprador;
    private final Produto produto;
    private final double valor;

    public Venda(Date data_venda, Usuario comprador, Produto produto,double valor) {
        this.id = count;
        this.data_venda = data_venda;
        this.comprador = comprador;
        this.produto = produto;
        this.valor = valor;
        count++;
    }

    public int getId() {
        return id;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }
    
}
