/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.Date;
import modelo.Venda;

/**
 *
 * @author 631510046
 */
public class vendaRepositorio {
    private static final ArrayList<Venda> VENDAS = new ArrayList<>();

    public ArrayList<Venda> getVENDAS() {
        return VENDAS;
    }
    
    public Venda getVenda(int id){
        return VENDAS.get(id);
    }
    
    public ArrayList<Venda> buscarVendas(Date data_inicial,Date data_final){
        ArrayList<Venda> vendas = new ArrayList<>();
        for(Venda v : VENDAS){
            if(v.getData_venda().after(data_inicial) && v.getData_venda().before(data_final))
                vendas.add(v);
        }
        if(vendas.isEmpty())
            return null;
        return vendas;
    }
    
    public ArrayList<Venda> buscarVendas(double preco_inicial,double preco_final){
        ArrayList<Venda> vendas = new ArrayList<>();
        for(Venda v : VENDAS){
            if(v.getProduto().getPreco()>=preco_inicial && v.getProduto().getPreco()<=preco_final)
                vendas.add(v);
        }
        if(vendas.isEmpty())
            return null;
        return vendas;
    }
}
