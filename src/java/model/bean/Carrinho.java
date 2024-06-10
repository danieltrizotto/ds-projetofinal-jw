/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class Carrinho {

    private int idCarrinho;
    private int fkUsuario;
    private int fkProduto;
    private int quantidade;
    ///variaveis para botar no select inner join do carrinho
    private int idProduto;
    private int fkCategoria;
    private String nome;
    private String descricao;
    private byte[] imgBlob;
    private String img;
    private float preço;
    private int estoque;

    public Carrinho(int idCarrinho, int fkUsuario, int fkProduto, int quantidade, int idProduto, int fkCategoria, String nome, String descricao, byte[] imgBlob, String img, float preço, int estoque) {
        this.idCarrinho = idCarrinho;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.fkCategoria = fkCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.imgBlob = imgBlob;
        this.img = img;
        this.preço = preço;
        this.estoque= estoque;
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

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(int fkCategoria) {
        this.fkCategoria = fkCategoria;
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

    public void setDescriçao(String descriçao) {
        this.descricao = descriçao;
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

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public int getEstoque(){
        return estoque;
}
    
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    
}
