/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class Produtos {
       private int id_Produto;
       private int fk_categoria;
    private String nome;
    private String descriçao;
    private byte[] imgBlob;
    private String img;
    private float preço;

    public Produtos(int id_Produto, int fk_categoria, String nome, String descriçao, byte[] imgBlob, String img, float preço) {
        this.id_Produto = id_Produto;
        this.fk_categoria = fk_categoria;
        this.nome = nome;
        this.descriçao = descriçao;
        this.imgBlob = imgBlob;
        this.img = img;
        this.preço = preço;
    }
   
    public Produtos(){
        
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public int getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(int fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
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
    
}
