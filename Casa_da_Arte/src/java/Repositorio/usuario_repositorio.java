/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Classes.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 631510046
 */
public class usuario_repositorio {
    private static final ArrayList<Usuario> USUARIOS = new ArrayList<>();

    public ArrayList<Usuario> getUSUARIOS() {
        return USUARIOS;
    }
    
    public Usuario getUsuario(String usuario,String senha){
        for(Usuario u : USUARIOS){
            if(u.getUsuario().equals(usuario) && u.getSenha().equals(senha) )
                return u;
        }
        return null;
    } 
}
