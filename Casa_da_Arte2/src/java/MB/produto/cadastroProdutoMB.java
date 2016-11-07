/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.produto;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Produto;
import repositorio.produtoRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "cadastroProdutoMB")
@RequestScoped
public class cadastroProdutoMB {
    //variaveis
    private int codigo,quantidade;
    private String nome,empresa,descricao;
    private double preco;
    //instancias
    produtoRepositorio pr = new produtoRepositorio();
    //injeções
    
    /**
     * Creates a new instance of cadastroProdutoMB
     */
    public cadastroProdutoMB() {
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
    
    public String limpar(){
        codigo = 0;
        quantidade = 0;
        nome = "";
        empresa = "";
        descricao = "";
        preco = 0;
        return "cadastro_produto";
    }
    
    public String cadastrar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        if(pr.existeProduto(codigo, empresa)){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Produto já existe!", "Não deve haver mais de um código na mesma empresa!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_produto";
        }else if(codigo <= 0 ||
        quantidade <= 0 ||
        nome.isEmpty() ||
        empresa.isEmpty() ||
        descricao.isEmpty() ||
        preco <= 0){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos vazios!", "Digite algo em todos os campos!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_produto"; 
        }else{
            pr.getPRODUTOS().add(new Produto(codigo,quantidade,nome,empresa,descricao,preco));
        }
        return "index_produto_admin";
    }
    
}
