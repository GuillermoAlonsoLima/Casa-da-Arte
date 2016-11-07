/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author 631510046
 */
public class produtoRepositorio {
    private static final ArrayList<Produto> PRODUTOS = new ArrayList<>();
    vendaRepositorio vr = new vendaRepositorio();
    public ArrayList<Produto> getPRODUTOS() {
        return PRODUTOS;
    }
    
    public Produto getProduto(int id){
        return PRODUTOS.get(id);
    }
    
    public ArrayList<Produto> buscarNome(String nome){
        ArrayList<Produto> produtos = new ArrayList<>();
        for(Produto p : PRODUTOS){
            if(p.getNome().contains(nome))
                produtos.add(p);
        }
        if(produtos.isEmpty())
            return null;
        return produtos;
    }
    
    public ArrayList<Produto> buscarEmpresa(String empresa){
        ArrayList<Produto> produtos = new ArrayList<>();
        for(Produto p : PRODUTOS){
            if(p.getEmpresa().contains(empresa))
                produtos.add(p);
        }
        if(produtos.isEmpty())
            return null;
        return produtos;
    }
    
    public ArrayList<Produto> buscarPreco(double preco_inicial,double preco_final){
        ArrayList<Produto> produtos = new ArrayList<>();
        for(Produto p : PRODUTOS){
            if(p.getPreco()>=preco_inicial && p.getPreco()>=preco_final)
                produtos.add(p);
        }
        if(produtos.isEmpty())
            return null;
        return produtos;
    }
    
    public boolean existeProduto(int codigo, String empresa){
        for(Produto p : PRODUTOS){
            if(p.getCodigo() == codigo && p.getEmpresa().equals(empresa))
                return true;
        }
        return false;
    }
    
    public boolean existeProduto(int codigo,String empresa,Produto produto){
        for(Produto p : PRODUTOS){
            if(p.getCodigo() == codigo && p.getEmpresa().equals(empresa) && p != produto)
                return true;
        }
        return false;
    }
    
    public void deletar(Produto produto){
        for(Venda v : vr.getVENDAS()){
            if(v.getProduto() == produto){
                vr.getVENDAS().remove(v);
            }
        }
        PRODUTOS.remove(produto);
    }
}
