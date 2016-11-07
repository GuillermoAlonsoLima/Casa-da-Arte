/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.produto;

import MB.venda.compraMB;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Produto;
import repositorio.produtoRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "indexProdutoUsuarioMB")
@ApplicationScoped
public class indexProdutoUsuarioMB {
    //instancias
    produtoRepositorio pr = new produtoRepositorio();
    //variaveis
    ArrayList<Produto> produtos_tabela = new ArrayList<>();
    private String tipo_pesquisa,pesquisa;
    private double preco_inicial,preco_final;
    //injeções
    @Inject
    compraMB compraMB;
    /**
     * Creates a new instance of indexProdutoUsuarioMB
     */
    public indexProdutoUsuarioMB() {
    }
    @PostConstruct
    public void init(){
        produtos_tabela = pr.getPRODUTOS();
    }

    public ArrayList<Produto> getProdutos_tabela() {
        return produtos_tabela;
    }

    public void setProdutos_tabela(ArrayList<Produto> produtos_tabela) {
        this.produtos_tabela = produtos_tabela;
    }

    public String getTipo_pesquisa() {
        return tipo_pesquisa;
    }

    public void setTipo_pesquisa(String tipo_pesquisa) {
        this.tipo_pesquisa = tipo_pesquisa;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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
    
    public String todos(){
        produtos_tabela = pr.getPRODUTOS();
        return "index_produto_admin";
    }
    
    public String pesquisar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        if(tipo_pesquisa.equals("nome"))
            produtos_tabela = pr.buscarNome(pesquisa);
        else
            produtos_tabela = pr.buscarEmpresa(pesquisa);
        if(produtos_tabela.isEmpty()){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca vazia!", "Não há nenhum usuario!");
            contexto.addMessage("idMensagem", mensagem);
        }
        return "index_produto_admin";
    }
    
    public String pesquisaPreco(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;        
        if(preco_inicial > preco_final){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Preço inválido!", "O preço inicial deve ser menor ou igual ao final!");
            contexto.addMessage("idMensagem", mensagem);
        }else if(produtos_tabela.isEmpty()){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca vazia!", "Não há nenhum usuario!");
            contexto.addMessage("idMensagem", mensagem);
        }else{
            produtos_tabela = pr.buscarPreco(preco_inicial, preco_final);
        }
        return "index_produto_admin";
    }
    
    public String comprar(Produto produto){
        compraMB.setProduto(produto);
        compraMB.init();
        return "/venda/compra";
    }
}
