/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.login;

import MB.usuario.edicaoUsuarioMB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.Produto;
import modelo.Usuario;
import repositorio.produtoRepositorio;
import repositorio.usuarioRepositorio;
import repositorio.vendaRepositorio;

/**
 *
 * @author 631510046
 */
@Named(value = "loginMB")
@SessionScoped
public class loginMB implements Serializable {
    //instancias
    private final usuarioRepositorio ur = new usuarioRepositorio();
    private final produtoRepositorio pr = new produtoRepositorio();
    private final vendaRepositorio vr = new vendaRepositorio();
    //variaveis
    private String usuario,senha;
    private Usuario logado;
    //injeções
    @Inject
    edicaoUsuarioMB edicaoUsuarioMB;
    
    /**
     * Creates a new instance of loginMB
     */
    public loginMB() {
    }
    
    @PostConstruct
    public void init(){
        ur.getUSUARIOS().add(new Usuario("anamaria","gaat1965","Ana Maria Alonso Lima","5134462883","5184295974","anamaria.elpinar@gmail.com","Rua Victorino José Goulart,116,São Tomé,Viamão,RS","94460260",new Date(),0,true));
        ur.getUSUARIOS().add(new Usuario("algeu","gaat1963","Algeu de Moura Lima","5134462883","5184295974","algeu.portinari@gmail.com","Rua Victorino José Goulart,116,São Tomé,Viamão,RS","94460260",new Date(),5000,false));
        pr.getPRODUTOS().add(new Produto(898989898,89,"roupa","ropa S.A.","roupa de bebe",89.89));
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getLogado() {
        return logado;
    }
    
    public String logar(){
        logado = ur.logar(usuario, senha);
        if(logado != null){
            if(logado.isAdmin())
                return "/produto/index_produto_admin";
            else 
                return "/produto/index_produto_usuario";
        }else{
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login inválido!", "Usuário ou senha estão errados!");
            contexto.addMessage("idMensagem", mensagem);
            return "login";
        }
    }
    
    public String editar(){
        edicaoUsuarioMB.init();
        return "/usuario/edicao_usuario";
    }
    
    public String logout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return ("/login/login");
    }
    
    public boolean isLogado(){
        return logado != null;
    }
}
