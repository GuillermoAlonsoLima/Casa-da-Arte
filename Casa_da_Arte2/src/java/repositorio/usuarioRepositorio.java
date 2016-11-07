/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.Venda;

/**
 *
 * @author 631510046
 */
public class usuarioRepositorio {
    private static final ArrayList<Usuario> USUARIOS = new ArrayList<>();
    vendaRepositorio vr = new vendaRepositorio();

    public ArrayList<Usuario> getUSUARIOS() {
        return USUARIOS;
    }
    
    public Usuario getUsuario(int id){
        return USUARIOS.get(id);
    }
    
    public ArrayList<Usuario> buscarUsuario(String usuario){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for(Usuario u : USUARIOS){
            if(u.getUsuario().contains(usuario))
                usuarios.add(u);
        }
        if(usuarios.isEmpty())
            return null;
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarNome(String nome){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for(Usuario u : USUARIOS){
            if(u.getNome().contains(nome))
                usuarios.add(u);
        }
        if(usuarios.isEmpty())
            return null;
        return usuarios;
    }
    
    public Usuario logar(String usuario,String senha){
        for(Usuario u : USUARIOS){
            if(u.getUsuario().equals(usuario) && u.getSenha().equals(senha))
                return u;
        }
        return null;
    }
    
    public boolean existeUsuario(String usuario){
        for(Usuario u : USUARIOS){
            if(usuario.equals(u.getUsuario()))
                return true;
        }
        return false;
    }
    
    public boolean existeUsuario(String usuario,Usuario Usuario){
        for(Usuario u : USUARIOS){
            if(usuario.equals(u.getUsuario()) && u != Usuario)
                return true;
        }
        return false;
    }
    
    public void deletar(Usuario usuario){
        for(Venda v : vr.getVENDAS()){
            if(v.getComprador() == usuario){
                vr.getVENDAS().remove(v);
            }
        }
        USUARIOS.remove(usuario);
    }
}
