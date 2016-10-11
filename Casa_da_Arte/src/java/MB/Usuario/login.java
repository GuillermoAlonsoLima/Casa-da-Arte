/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.produto;
import Classes.Usuario;
import Classes.venda;
import MB.Produto.produtos;
import Repositorio.produto_repositorio;
import Repositorio.usuario_repositorio;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "login")
@Dependent
public class login {
    private String usuario,senha,msg;
    private static Usuario logado;
    usuario_repositorio ur = new usuario_repositorio();
    produtos p = new produtos();
    private produto_repositorio pr = new produto_repositorio();
    /**
     * Creates a new instance of Login
     */
    public login() {
        
    }

    @PostConstruct
    public void init(){
        Usuario.setCount(1);
        produto.setCount(1);
        venda.setCount(1);
        ur.getUSUARIOS().add(new Usuario("Ana Maria Alonso Lima","anamaria","gaat1965",94460260,0,true));
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public usuario_repositorio getUr() {
        return ur;
    }

    public void setUr(usuario_repositorio ur) {
        this.ur = ur;
    }

    public Usuario getLogado() {
        return logado;
    }
    
    public void setLogado(Usuario logado){
        login.logado = logado;
    }
    
    
    public String logar(){
        Usuario user = ur.getUsuario(usuario, senha);
        if(user == null){
            msg = "Usuario e/ou Senha incorretos!";
            return "login";
        }else{
            logado = user;
            if(user.isAdmin()){                
                return "/produto/produtos_admin";
            }else{
                p.setProdutos(pr.getPRODUTOS());
                return "/produto/produtos";
            }
        }
    }
    
}
