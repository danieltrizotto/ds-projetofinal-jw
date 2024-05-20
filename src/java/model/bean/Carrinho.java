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

   
    private int idCarrinho;
    private int fkUsuario;
    private int fkProduto;
    private int quantidade;
    private String nome;
    private float valor_uni;
    private float valor_total;
    private int fkCategoia;
    private byte[] imgBlob;
    private String img;

    public Carrinho( int idCarrinho, int fkUsuario, int fkProduto, int quantidade, String nome, float valor_uni, float valor_total, int fkCategoia, byte[] imgBlob, String img) {
      
        this.idCarrinho = idCarrinho;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.quantidade = quantidade;
        this.nome = nome;
        this.valor_uni = valor_uni;
        this.valor_total = valor_total;
        this.fkCategoia = fkCategoia;
        this.imgBlob = imgBlob;
        this.img = img;
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

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(float valor_uni) {
        this.valor_uni = valor_uni;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getFkCategoia() {
        return fkCategoia;
    }

    public void setFkCategoia(int fkCategoia) {
        this.fkCategoia = fkCategoia;
    }

    public byte[] getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(byte[] imgBlob) {
        this.imgBlob = imgBlob;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
