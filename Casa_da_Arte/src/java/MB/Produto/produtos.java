/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Produto;

import Classes.produto;
import Classes.Usuario;
import MB.Usuario.login;
import Repositorio.produto_repositorio;
import Repositorio.usuario_repositorio;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "produtos")
@Dependent
public class produtos {
    private double preco_inicial,preco_final;
    private String nome;
    private ArrayList<produto> produtos = new ArrayList<>();
    private final produto_repositorio pr = new produto_repositorio();
    private final login l = new login();
    private final usuario_repositorio ur = new usuario_repositorio();
    private final compra c = new compra();
    /**
     * Creates a new instance of Produtos
     */
    public produtos() {
    }

    public double getPreco_inicial() {
        return preco_inicial;
    }

    public double getPreco_final() {
        return preco_final;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<produto> getProdutos() {
        return produtos;
    }

    public void setPreco_inicial(double preco_inicial) {
        this.preco_inicial = preco_inicial;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public String deletarUsuario(){
        Usuario user = l.getLogado();
        l.setLogado(null);
        ur.getUSUARIOS().remove(user);
        return "/usuario/login";
    }
    
    public String logout(){
        l.setLogado(null);
        return "/usuario/login";
    }
    
    public String comprarProduto(produto produto){
        c.setProduto(produto);
        return "compra";
    }
    
}
