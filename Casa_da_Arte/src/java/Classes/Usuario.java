/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 631510046
 */
public class Usuario {
    private static int count;
    private final int id;
    private String nome,usuario,senha;
    private int cep;
    private double saldo;
    private final boolean admin;

    public Usuario(String nome, String usuario, String senha, int cep, double saldo,boolean admin) {
        this.id = count;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.cep = cep;
        this.admin = admin;
        this.saldo = saldo;
        count++;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Usuario.count = count;
    }
    
    
}
