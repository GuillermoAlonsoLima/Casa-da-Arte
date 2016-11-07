/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.venda;

import MB.login.loginMB;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.Produto;
import modelo.Venda;
import repositorio.vendaRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "compraMB")
@SessionScoped
public class compraMB implements Serializable{
    //variaveis
    private int codigo,quantidade;
    private int quantidade_comprar;
    private String nome,empresa,descricao;
    private double preco;
    private Produto produto;
    //instancias
    vendaRepositorio vr = new vendaRepositorio();
    //injeções
    @Inject
    loginMB loginMB;
    /**
     * Creates a new instance of compraMB
     */
    public compraMB() {
        
    }

    public void init(){
        codigo = produto.getCodigo();
        quantidade = produto.getQuantidade();
        nome = produto.getNome();
        empresa = produto.getEmpresa();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade_comprar() {
        return quantidade_comprar;
    }

    public void setQuantidade_comprar(int quantidade_comprar) {
        this.quantidade_comprar = quantidade_comprar;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String comprar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        if(loginMB.getLogado().getSaldo() < preco*quantidade_comprar){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Saldo insuficiente!", "Não há dinheiro suficiente para completar compra!");
            contexto.addMessage("idMensagem", mensagem);
            return "compra";
        }else if(quantidade < quantidade_comprar){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Quantidade insuficiente!", "Não há produtos suficiente para completar compra!");
            contexto.addMessage("idMensagem", mensagem);
            return "compra";
        }else if(quantidade_comprar <= 0){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Quantidade nula!", "Quantidade deve ser maior que zero!");
            contexto.addMessage("idMensagem", mensagem);
            return "compra";
        }else{
            loginMB.getLogado().setSaldo(loginMB.getLogado().getSaldo() - quantidade_comprar*preco);
            produto.setQuantidade(quantidade - quantidade_comprar);
            vr.getVENDAS().add(new Venda(new Date(),loginMB.getLogado(),produto,quantidade_comprar*preco));
            return "/produto/index_produto_usuario";
        }
    }
}
