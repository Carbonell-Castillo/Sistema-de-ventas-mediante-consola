/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPC1Practice1;

/**
 *
 * @author bruce
 */
public class Coupon {
    private String name;
    private Float discount;
    private Boolean used;
    
    public Coupon(){
        name="";
        discount=0f;
        used=false;
    }
    
    public Coupon(String name, Float discount, Boolean used) {
        this.name = name;
        this.discount = discount;
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
    
    
}
