/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Classes.produto;
import MB.Usuario.login;
import Repositorio.produto_repositorio;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "produtos_admin")
@Dependent
public class produtos_admin {
    private double preco_inicial,preco_final;
    private String nome;
    private ArrayList<produto> produtos = new ArrayList<>();
    private final produto_repositorio pr = new produto_repositorio();
    private final login l = new login();
    private final edicao_produto e = new edicao_produto();
    /**
     * Creates a new instance of Produtos_admin
     */
    public produtos_admin() {
    }

    public double getPreco_inicial() {
        return preco_inicial;
    }

    public void setPreco_inicial(double preco_inicial) {
        this.preco_inicial = preco_inicial;
    }

    public double getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<produto> produtos) {
        this.produtos = produtos;
    }
    public String pesquisar(){
        produtos = pr.buscarProdutos(preco_inicial, preco_final, nome);
        return "produtos";
    }
    
    public String todos(){
        produtos = pr.getPRODUTOS();
        return "produtos";
    }
    
    public String logout(){
        l.setLogado(null);
        return "/usuario/login";
    }
    
    public String editarProduto(produto produto){
        e.setProduto(produto);
        return "edicao";
    }
    
    public String deletarProduto(produto produto){
        pr.getPRODUTOS().remove(produto);
        return "produtos_admin";
    }
    
}
