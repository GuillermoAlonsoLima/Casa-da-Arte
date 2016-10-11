/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author 631510046
 */
public class Venda {
    private static int count;
    private final int id;
    private Produto produto;
    private Usuario usuario;
    private Date data;

    public Venda(Produto produto, Usuario usuario, Date data) {
        this.id = count;
        this.produto = produto;
        this.usuario = usuario;
        this.data = data;
        count++;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Venda.count = count;
    }
    
    
    
}
