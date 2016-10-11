/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Usuario;

import Classes.Usuario;
import Repositorio.usuario_repositorio;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Guillermo1
 */
@Named(value = "usuarios")
@Dependent
public class usuarios {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private final usuario_repositorio ur = new usuario_repositorio();
    /**
     * Creates a new instance of Usuarios
     */
    public usuarios() {
        usuarios = ur.getUSUARIOS();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String deletarUsuario(Usuario usuario){
        ur.getUSUARIOS().remove(usuario);
        return "usuarios";
    }
    
}
