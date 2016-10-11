/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Repositorio.Produto_Repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "edicao")
@Dependent
public class Edicao {
    private String nome,descricao;
    private double preco;
    Produto_Repositorio pr = new Produto_Repositorio();
    /**
     * Creates a new instance of Edicao
     */
    public Edicao() {
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

    public Produto_Repositorio getPr() {
        return pr;
    }

    public void setPr(Produto_Repositorio pr) {
        this.pr = pr;
    }
    
    public String 
    
}
