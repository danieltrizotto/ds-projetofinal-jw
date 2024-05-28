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
public class Endereço {
     private int id_endereco;
    private int fk_endereco;
    private String rua;
    private int numero;
    private String cep;

    public Endereço(int id_endereco, int fk_endereco, String rua, int numero, String cep) {
        this.id_endereco = id_endereco;
        this.fk_endereco = fk_endereco;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }
public Endereço(){
    
}
    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getFk_endereco() {
        return fk_endereco;
    }

    public void setFk_endereco(int fk_endereco) {
        this.fk_endereco = fk_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
