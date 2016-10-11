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
public class produto {
    private static int count;
    private final int id;
    private String nome,descricao;
    private double preco;

    public produto(String nome, String descricao, double preco) {
        this.id = count;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        count++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        produto.count = count;
    }
    
    
}
