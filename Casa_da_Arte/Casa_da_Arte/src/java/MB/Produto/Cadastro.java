/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Classes.Produto;
import Repositorio.Produto_Repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "cadastro")
@Dependent
public class Cadastro {
    private String nome,descricao;
    private double preco;
    Produto_Repositorio pr = new Produto_Repositorio();
    /**
     * Creates a new instance of Cadastro
     */
    public Cadastro() {
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
    
    public String cadastrar(){
        pr.getPRODUTOS().add(new Produto(nome,descricao,preco));
        return "produto/produtos_admin";
    }
}
