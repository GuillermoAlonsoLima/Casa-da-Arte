/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.usuario;

import Util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import repositorio.usuarioRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "indexUsuarioMB")
@ApplicationScoped
public class indexUsuarioMB {
    //instancias
    usuarioRepositorio ur = new usuarioRepositorio();
    //variaveis
    ArrayList<Usuario> usuarios_tabela = new ArrayList<>();
    private String tipo_pesquisa,pesquisa;
    //injeções
    /**
     * Creates a new instance of indexUsuarioMB
     */
    public indexUsuarioMB() {
        
    }
    @PostConstruct
    public void init(){
        usuarios_tabela = ur.getUSUARIOS();
    }

    public ArrayList<Usuario> getUsuarios_tabela() {
        return usuarios_tabela;
    }

    public void setUsuarios_tabela(ArrayList<Usuario> usuarios_tabela) {
        this.usuarios_tabela = usuarios_tabela;
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
    
    public String todos(){
        usuarios_tabela = ur.getUSUARIOS();
        return "index_usuario";
    }
    
    public String dateToString(Date date){
        return DateUtil.dateToString(date);
    }
    
    public String pesquisar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;  
        if(tipo_pesquisa.equals("usuario"))
            usuarios_tabela = ur.buscarNome(pesquisa);
        else
            usuarios_tabela = ur.buscarUsuario(pesquisa);
        if(usuarios_tabela.isEmpty()){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca vazia!", "Não há nenhum usuario!");
            contexto.addMessage("idMensagem", mensagem);
        }
        return "index_usuario";
    }
    
    public String deletar(Usuario usuario){
        ur.deletar(usuario);
        usuarios_tabela = ur.getUSUARIOS();
        return "index_usuario";
    }
    
}
