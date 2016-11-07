/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 631510046
 */
public class Produto {
    private static int count = 1;
    private final int id;
    private int codigo,quantidade;
    private String nome,empresa,descricao;
    private double preco;

    public Produto(int codigo, int quantidade, String nome, String empresa, String descricao, double preco) {
        this.id = count;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nome = nome;
        this.empresa = empresa;
        this.descricao = descricao;
        this.preco = preco;
        count++;
    }

    public int getId() {
        return id;
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
