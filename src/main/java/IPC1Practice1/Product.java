/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPC1Practice1;

/**
 *
 * @author bruce
 */
public class Product {
    private Integer n;
    private String name;
    private Float price;
    
    public Product(){
        n=0;
        name="";
        price=0f;
    }
    
    public Product(Integer n, String name, Float price) {
        this.n= n;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }
    
    
}
