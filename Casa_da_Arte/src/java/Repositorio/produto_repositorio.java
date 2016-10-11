/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Classes.produto;
import java.util.ArrayList;

/**
 *
 * @author 631510046
 */
public class produto_repositorio {
    private static final ArrayList<produto> PRODUTOS = new ArrayList<>();

    public ArrayList<produto> getPRODUTOS() {
        return PRODUTOS;
    }
    
    public produto getProduto(int id){
        for(produto p : PRODUTOS){
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    
    public ArrayList<produto> buscarProdutos(Double preco_inicial,Double preco_final,String nome){
        ArrayList<produto> produtos = new ArrayList<>();
        for(produto p : PRODUTOS){
            if(p.getPreco() >= preco_inicial && p.getPreco() <= preco_final && p.getNome().contains(nome))
                produtos.add(p);
        }
        return produtos;
    }
}
