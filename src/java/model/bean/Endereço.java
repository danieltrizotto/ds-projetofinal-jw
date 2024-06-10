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
    private int fk_usuario;
    private String rua;
    private int numero;
    private String cep;

    public Endereço() {

    }

    public Endereço(int id_endereco, int fk_usuario, String rua, int numero, String cep) {
        this.id_endereco = id_endereco;
        this.fk_usuario = fk_usuario;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
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
