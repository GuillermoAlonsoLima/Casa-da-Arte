/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB.Venda;

import Classes.venda;
import Repositorio.venda_repositorio;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 631510046
 */
@Named(value = "vendas")
@Dependent
public class vendas {
    ArrayList<venda> vendas = new ArrayList<>();
    venda_repositorio vr = new venda_repositorio();
    /**
     * Creates a new instance of Vendas
     */
    public vendas() {
        vendas = vr.getVENDAS();
    }

    public ArrayList<venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<venda> vendas) {
        this.vendas = vendas;
    }

    public venda_repositorio getVr() {
        return vr;
    }

    public void setVr(venda_repositorio vr) {
        this.vr = vr;
    }
    
    public String deletarVenda(venda venda){
        vr.getVENDAS().remove(venda);
        return "vendas";
    }
    
}
