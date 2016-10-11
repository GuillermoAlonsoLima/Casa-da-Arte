/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.Produto;
import Classes.Usuario;
import Classes.Venda;
import Repositorio.Usuario_Repositorio;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "login")
@Dependent
public class Login {
    private String usuario,senha,msg;
    private static Usuario logado;
    Usuario_Repositorio ur = new Usuario_Repositorio();
    /**
     * Creates a new instance of Login
     */
    public Login() {
        
    }

    @PostConstruct
    public void init(){
        Usuario.setCount(1);
        Produto.setCount(1);
        Venda.setCount(1);
        ur.getUSUARIOS().add(new Usuario("Ana Maria Alonso Lima","anamaria","gaat1965",94460260,true));
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

    public Usuario_Repositorio getUr() {
        return ur;
    }

    public void setUr(Usuario_Repositorio ur) {
        this.ur = ur;
    }

    public Usuario getLogado() {
        return logado;
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
                return "/produto/produtos";
            }
        }
    }
    
}
