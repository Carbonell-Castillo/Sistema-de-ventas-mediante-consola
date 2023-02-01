/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;

/**
 *
 * @author bruce
 */
public class Business extends Identity{
    private String cashierName;
    private Float subtotal;
    private Float discount;
    private Float Total;
    
    public Business(){
        cashierName="";
        subtotal=0f;
        discount=0f;
        Total=0f;
    }
    
    public Business(String cashierName, Float subtotal, Float discount, Float Total) {
        this.cashierName = cashierName;
        this.subtotal = subtotal;
        this.discount = discount;
        this.Total = Total;
    }

    public Business(String cashierName, Float subtotal, Float discount, Float Total, String name, String nit, String date) {
        super(name, nit, date);
        this.cashierName = cashierName;
        this.subtotal = subtotal;
        this.discount = discount;
        this.Total = Total;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }
    
}
