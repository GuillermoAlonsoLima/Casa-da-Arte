/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Classes.Produto;
import java.util.ArrayList;

/**
 *
 * @author 631510046
 */
public class Produto_Repositorio {
    private static final ArrayList<Produto> PRODUTOS = new ArrayList<>();

    public ArrayList<Produto> getPRODUTOS() {
        return PRODUTOS;
    }
    
    public Produto getProduto(int id){
        for(Produto p : PRODUTOS){
            if(p.getId() == id)
                return p;
        }
        return null;
    }
}
