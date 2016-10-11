/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Classes.produto;
import Classes.venda;
import MB.Usuario.login;
import Repositorio.venda_repositorio;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "compra")
@Dependent
public class compra {
    private String nome,descricao;
    private double preco;
    private static produto produto;
    login l = new login();
    venda_repositorio vr = new venda_repositorio();
    /**
     * Creates a new instance of Compra
     */
    public compra() {
        nome = produto.getNome();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        compra.produto = produto;
    }
    
    public String comprar(){
        vr.getVENDAS().add(new venda(produto,l.getLogado(),new Date()));
        return "produtos";
    }
}
