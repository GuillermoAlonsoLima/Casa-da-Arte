/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.usuario;

import Util.DateUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import repositorio.usuarioRepositorio;

/**
 *
 * @author Guillermo1
 */
@Named(value = "cadastroUsuarioMB")
@RequestScoped
public class cadastroUsuarioMB {
    //instancias
    usuarioRepositorio ur = new usuarioRepositorio();
    //variaveis
    private String usuario,senha,nome,fixo,celular,email,endereco,cep;
    private double saldo;
    //injeções
    
    /**
     * Creates a new instance of cadastroUsuarioMB
     */
    public cadastroUsuarioMB() {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String limpar(){
        usuario = "";
        senha = "";
        nome = "";
        fixo = "";
        celular = "";
        email = "";
        endereco = "";
        cep = "";
        saldo = 0;
        return "cadastro_usuario";
    }
    
    public String cadastrar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        if(ur.existeUsuario(usuario)){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuario já existe!", "Use outro nome de usuario!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_usuario";
        }else if(!senha.matches(".*[a-z].*") || !senha.matches(".*[0-9].*")){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Senha inválida!", "Senha deve ter números e letras minusculas!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_usuario";
        }else if(!email.matches(".*@.*\\..*")){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "E-mail inválido!", "O Email deve ter o formato de _@_._!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_usuario";
//        }else if(!endereco.matches("[a-zA-Z ]+[,]\\d+[,][a-zA-Z ]+[,][a-zA-Z ]+[,][a-zA-Z ]+")){
//            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Endereço inválido!", "O Endereço deve ter o formato de rua,numero de casa,bairro,cidade,estado!");
//            contexto.addMessage("idMensagem", mensagem);
//            return "cadastro_usuario";
        }else if(fixo.length()<10 || celular.length()<10){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Telefones inválido!", "Os telefones devem ter no mínmimo 10 números!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_usuario";
        }else if(usuario.isEmpty() || 
            senha.isEmpty() || 
            nome.isEmpty() || 
            fixo.isEmpty() || 
            celular.isEmpty() || 
            email.isEmpty() || 
            endereco.isEmpty() || 
            cep.isEmpty() || 
            saldo <= 0){
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos vazios!", "Digite algo em todos os campos!");
            contexto.addMessage("idMensagem", mensagem);
            return "cadastro_usuario";         
        }else{
            ur.getUSUARIOS().add(new Usuario(usuario,senha,nome,fixo,celular,email,endereco,cep,new Date(),saldo,false));
            return "/login/login";
        }
    }
}
