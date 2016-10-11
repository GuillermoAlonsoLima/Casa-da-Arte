/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Repositorio.Usuario_Repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "editar_Usuario")
@Dependent
public class Edicao {
    private String nome,usuario,senha;
    private long cep;
    Usuario_Repositorio ur = new Usuario_Repositorio();
    Login l = new Login();
    /**
     * Creates a new instance of Editar_Usuario
     */
    public Edicao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public Usuario_Repositorio getUr() {
        return ur;
    }

    public void setUr(Usuario_Repositorio ur) {
        this.ur = ur;
    }

    public Login getL() {
        return l;
    }

    public void setL(Login l) {
        this.l = l;
    }
    
    
    
    public String editar(){
        l.getLogado().setCep(cep);
        l.getLogado().setNome(nome);
        l.getLogado().setSenha(senha);
        l.getLogado().setUsuario(usuario);
        if(l.getLogado().isAdmin()){                
            return "/produto/produtos_admin";
        }else{
            return "/produto/produtos";
        }
    }
    
}
