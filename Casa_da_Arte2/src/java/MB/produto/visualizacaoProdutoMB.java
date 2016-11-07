/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.produto;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import modelo.Produto;

/**
 *
 * @author Guillermo1
 */
@Named(value = "visualizacaoProdutoMB")
@SessionScoped
public class visualizacaoProdutoMB implements Serializable{
    //variaveis
    private Produto produto;
    private int codigo,quantidade;
    private String nome,empresa,descricao;
    private double preco;
    //instancias
    //injeções
    
    /**
     * Creates a new instance of visualizacaoProdutoMB
     */
    public visualizacaoProdutoMB() {
        
    }

    public void init(){
        codigo = produto.getCodigo();
        quantidade = produto.getQuantidade();
        nome = produto.getNome();
        empresa = produto.getEmpresa();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
    
    
}
