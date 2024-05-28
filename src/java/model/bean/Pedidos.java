/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Senai
 */
public class Pedidos {
    private int idPedido;
    private int fkUsuario;
    private int fkEndereco;
    private String pagamento;
    private String modo_pago;
    private float valor_total;
    private Date data_hora;

    public Pedidos(int idPedido, int fkUsuario, int fkEndereco, String pagamento, String modo_pago, float valor_total, Date data_hora) {
        this.idPedido = idPedido;
        this.fkUsuario = fkUsuario;
        this.fkEndereco = fkEndereco;
        this.pagamento = pagamento;
        this.modo_pago = modo_pago;
        this.valor_total = valor_total;
        this.data_hora = data_hora;
    }
    public Pedidos(){
        
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(int fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getModo_pago() {
        return modo_pago;
    }

    public void setModo_pago(String modo_pago) {
        this.modo_pago = modo_pago;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }
    
}
