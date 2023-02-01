/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;

import java.util.Scanner;

/**
 *
 * @author bruce
 */
public class Tester {
    
    public static void main(String[] args) {
 
    SG sg = new SG();
    
    sg.setNewProducts(5);
    
        System.out.println("Cantidad "+ sg.products.length);
        String name="coca";
        Float price=10.2f;
        
        for (int i = 0; i < sg.products.length ; i++) {
            if(sg.products[i] != null){
                if(sg.products[i].getName().equals(name)){
                    System.out.println("El nombre del producto ya existe, ingreselo nuevamente");
                    break;
                }
            }else{
                System.out.println("entro 2");
                if(price<=0){
                    System.out.println("El precio del producto es menor a cero, ingreselo nuevamente");
                    
                    break;
                }else{
                    
                    sg.products[i]= new Product(name, price);
                    System.out.println("------------------------------------");
                    System.out.println("Registro del producto exitosamente No. "+ (i+1));
                    System.out.println("Nombre del producto: "+ sg.products[i].getName());
                    System.out.println("Precio del producto: "+ sg.products[i].getPrice());
                    System.out.println("------------------------------------");
                    break;
                }
            }
        }
        
        
    }
 
}
