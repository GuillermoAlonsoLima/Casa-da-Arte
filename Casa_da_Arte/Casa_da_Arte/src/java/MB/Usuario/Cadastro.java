/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.Usuario;
import Repositorio.Usuario_Repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "cadastro")
@Dependent
public class Cadastro {
    private String nome,usuario,senha;
    private long cep;
    Usuario_Repositorio ur = new Usuario_Repositorio();
    /**
     * Creates a new instance of Cadastro
     */
    public Cadastro() {
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
                                                 
    public String cadastrar(){
        ur.getUSUARIOS().add(new Usuario(nome,usuario,senha,cep,false));
        return "login";
    }
}
