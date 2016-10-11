/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "editar_Usuario")
@Dependent
public class edicao_usuario {
    private String nome,usuario,senha;
    private int cep;
    private double saldo;
    login l = new login();
    /**
     * Creates a new instance of Editar_Usuario
     */
    public edicao_usuario() {
       Usuario user = l.getLogado();
       nome = user.getNome();
       usuario = user.getUsuario();
       senha = user.getSenha();
       cep = user.getCep();
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

    public void setCep(int cep) {
        this.cep = cep;
    }

    public login getL() {
        return l;
    }

    public void setL(login l) {
        this.l = l;
    }
    
    public String editar(){
        l.getLogado().setCep(cep);
        l.getLogado().setNome(nome);
        l.getLogado().setSenha(senha);
        l.getLogado().setUsuario(usuario);
        l.getLogado().setSaldo(saldo);
        if(l.getLogado().isAdmin()){                
            return "/produto/produtos_admin";
        }else{
            return "/produto/produtos";
        }
    }
    
}
