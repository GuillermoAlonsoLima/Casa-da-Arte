/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Classes.produto;
import Repositorio.produto_repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "edicao")
@Dependent
public class edicao_produto {
    private String nome,descricao;
    private double preco;
    private static produto produto;
    private final produto_repositorio pr = new produto_repositorio();
    /**
     * Creates a new instance of Edicao
     */
    public edicao_produto() {
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
    
    public String editar(){
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setDescricao(descricao);
        return "produtos_admin";
    }

    void setProduto(produto produto) {
        edicao_produto.produto = produto;
    }
    
}
