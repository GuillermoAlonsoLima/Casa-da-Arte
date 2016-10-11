/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.Usuario;
import Repositorio.usuario_repositorio;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "cadastro")
@Dependent
public class cadastro_usuario {
    private String nome,usuario,senha;
    private int cep;
    private double saldo;
    usuario_repositorio ur = new usuario_repositorio();
    login l = new login();
    /**
     * Creates a new instance of Cadastro
     */
    public cadastro_usuario() {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

        
    public String cadastrar(){
        Usuario user = new Usuario(nome,usuario,senha,cep,saldo,false);
        ur.getUSUARIOS().add(user);
        l.setLogado(user);
        return "produtos";
    }
}
