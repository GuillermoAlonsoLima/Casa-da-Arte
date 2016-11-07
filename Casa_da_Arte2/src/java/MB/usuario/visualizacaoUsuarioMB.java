/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.usuario;

import Util.DateUtil;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import modelo.Usuario;

/**
 *
 * @author Guillermo1
 */
@Named(value = "visualizacaoUsuarioMB")
@SessionScoped
public class visualizacaoUsuarioMB implements Serializable{
    private Usuario usuario_entidade;
    private String usuario,senha,nome,fixo,celular,email,endereco,cep,data_cadastro;
    private double saldo;
    /**
     * Creates a new instance of visualizacaoUsuarioMB
     */
    public visualizacaoUsuarioMB() {
        
    }

    public void init(){
        usuario= usuario_entidade.getUsuario();
        senha = usuario_entidade.getSenha();
        nome = usuario_entidade.getNome();
        fixo = usuario_entidade.getFixo();
        celular = usuario_entidade.getCelular();
        email = usuario_entidade.getEmail();
        endereco = usuario_entidade.getEndereco();
        cep = usuario_entidade.getCep();
        data_cadastro = DateUtil.dateToString(usuario_entidade.getData_cadastro());
        saldo = usuario_entidade.getSaldo();
    }

    public Usuario getUsuario_entidade() {
        return usuario_entidade;
    }

    public void setUsuario_entidade(Usuario usuario_entidade) {
        this.usuario_entidade = usuario_entidade;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
