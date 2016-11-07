/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.produto;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Produto;
import repositorio.produtoRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "edicaoProdutoMB")
@SessionScoped
public class edicaoProdutoMB  implements Serializable {
    //variaveis
    private int codigo,quantidade;
    private String nome,empresa,descricao;
    private double preco;
    private Produto produto;
    //instancias
    produtoRepositorio pr = new produtoRepositorio();
    //injeções
    
    /**
     * Creates a new instance of edicaoProdutoMB
     */
    public edicaoProdutoMB() {
        
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String limpar(){
        codigo = 0;
        quantidade = 0;
        nome = "";
        empresa = "";
        descricao = "";
        preco = 0;
        return "edicao_produto";
    }
    
    public String editar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
//        if(pr.existeProduto(codigo, empresa,produto)){
//            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Produto já existe!", "Não deve haver mais de um código na mesma empresa!");
//            contexto.addMessage("idMensagem", mensagem);
//            return "edicao_produto";
//        }else 
            if(codigo <= 0 ||
        quantidade <= 0 ||
        nome.isEmpty() ||
        empresa.isEmpty() ||
        descricao.isEmpty() ||
        preco <= 0){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos vazios!", "Digite algo em todos os campos!");
            contexto.addMessage("idMensagem", mensagem);
            return "edicao_produto"; 
        }else{
            produto.setCodigo(codigo);
            produto.setDescricao(descricao);
            produto.setEmpresa(empresa);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            return "index_produto_admin";
        }
        
    }
    
}
