/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Senai
 */
public class Carrinho {
 private List<CarrinhoItem> itens;
    private int idCarrinho;
    private int fkUsuario;
    private int fkProduto;
    private String nome;
    private static String nomeProduto;
    private int quantidade;
    private float preçoUnitario;
    private byte[] imgBlob;

    public Carrinho(int idCarrinho, int fkUsuario, int fkProduto, int quantidade, float preçoUnitario, String nome, byte[] imgBlob) {
        this.idCarrinho = idCarrinho;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preçoUnitario = preçoUnitario;
        this.imgBlob = imgBlob;
           this.itens = new ArrayList<>();
    }

    public Carrinho() {

    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public byte[] getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(byte[] imgBlob) {
        this.imgBlob = imgBlob;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public static String getNomeProduto() {
        return nomeProduto;
    }

    public static void setNomeProduto(String nomeProduto) {
        Carrinho.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreçoUnitario() {
        return preçoUnitario;
    }

    public void setPreçoUnitario(float preçoUnitario) {
        this.preçoUnitario = preçoUnitario;
    }
    
     public List<CarrinhoItem> getItens() {
        return itens;
    }

    public void adicionarItem(CarrinhoItem item) {
        itens.add(item);
    }

}
