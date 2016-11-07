/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.venda;

import MB.produto.visualizacaoProdutoMB;
import MB.usuario.visualizacaoUsuarioMB;
import Util.DateUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.Produto;
import modelo.Usuario;
import modelo.Venda;
import repositorio.vendaRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "indexVendaMB")
@ApplicationScoped
public class indexVendaMB {
    //variaveis
    private String data_inicial,data_final;
    private double preco_inicial,preco_final,total;
    ArrayList<Venda> vendas_tabela = new ArrayList<>();
    //instancias
    vendaRepositorio vr = new vendaRepositorio();
    //injeções
    @Inject
    visualizacaoProdutoMB visualizacaoProdutoMB;
    @Inject
    visualizacaoUsuarioMB visualizacaoUsuarioMB;
    /**
     * Creates a new instance of indexVendaMB
     */
    public indexVendaMB() {
        vendas_tabela = vr.getVENDAS();
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
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

    public void setPreco_final(double _preco_final) {
        this.preco_final = _preco_final;
    }

    public ArrayList<Venda> getVendas_tabela() {
        return vendas_tabela;
    }

    public void setVendas_tabela(ArrayList<Venda> vendas_tabela) {
        this.vendas_tabela = vendas_tabela;
    }
    
    public String pesquisarData(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        try {
            if(DateUtil.stringToDate(data_inicial).after(DateUtil.stringToDate(data_final))){
                mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Data inválida!", "A data inicial ocorrer no mesmo tempo ou antes da final!");
                contexto.addMessage("idMensagem", mensagem);
            }else{
                vendas_tabela = vr.buscarVendas(DateUtil.stringToDate(data_inicial), DateUtil.stringToDate(data_final));
                total();
            }
        } catch (ParseException ex) {
            Logger.getLogger(indexVendaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index_venda";
    }
    
    public String pesquisarPreco(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        if(preco_inicial > preco_final){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Preço inválido!", "O preço inicial deve ser menor ou igual ao final!");
            contexto.addMessage("idMensagem", mensagem);
        }else if(vendas_tabela.isEmpty()){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca vazia!", "Não há nenhum usuario!");
            contexto.addMessage("idMensagem", mensagem);
        }else{
            vendas_tabela = vr.buscarVendas(preco_inicial, preco_final);
            total();
        }
        return "index_venda";
    }
    
    public String deletar(Venda venda){
        vr.getVENDAS().remove(venda);
        vendas_tabela = vr.getVENDAS();
        total();
        return "index_venda";
    }
    
    public void total(){
        for(Venda v : vendas_tabela){
            total += v.getValor();
        }
    }
    
    public void todos(){
        vendas_tabela = vr.getVENDAS();
    }
    
    public String dateToString(Date data){
        return DateUtil.dateToString(data);
    }
    
    public String visulizarComprador(Usuario usuario){
         visualizacaoUsuarioMB.setUsuario_entidade(usuario);
         visualizacaoUsuarioMB.init();
        return "/usuario/visualizacao_usuario";
    }
    
    public String visulizarProduto(Produto produto){
        visualizacaoProdutoMB.setProduto(produto);
        visualizacaoProdutoMB.init();
        return "/produto/visualizacao_produto";
    }
}
