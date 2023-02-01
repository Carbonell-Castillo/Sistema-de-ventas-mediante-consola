/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;

/**
 *
 * @author bruce
 */

import java.util.Scanner;
public class SG {
    //Important data
    
    public Product[] products;
    public Coupon[] coupons;
    
    Scanner readData = new Scanner(System.in);
    //menu
    
    
    public static void showMessage(String message){
        System.out.println(message);
        
    }
    
    public String getDataString(String message){
        String data="";
            showMessage(message);
            data= readData.nextLine();
        return data;
    }
    
    public Float getDataFloat(String message){
        Float num=0f;
        boolean validation=false;
        do {            
            try {
                showMessage(message);
                 num= Float.parseFloat(readData.nextLine());        
                validation=true;
            } catch (Exception e) {
                showMessage("Error ingreselo nuevamente");
            }
        } while (!validation);
        
        return num;
    }
    
    public Integer getDataInteger(String message){
        Integer num=0;
        boolean validation=false;
        do {            
            try {
                showMessage(message);
                 num= Integer.parseInt(readData.nextLine());        
                validation=true;
            } catch (Exception e) {
                showMessage("Error ingreselo nuevamente");
            }
        } while (!validation);
        
        return num;
    }
    
    
    public Integer menu(){
        Integer option=0;
        do {            
           System.out.println("----Menu---");
           System.out.println("Seleccione una opcion");
           System.out.println("1. Agregar nuevos productos al sistema");
           System.out.println("2. Agregar nuevos codigos promocionales de descuento al sistema");
           System.out.println("3. Realizar ventas");
           System.out.println("4. Aplicar descuentos a las compras con codigos promocionales");
           System.out.println("5. Emitir factura");
           option= readData.nextInt();
           if(option<0 || option>7){
               System.out.println("Opcion seleccionada incorrecta, vuelva a selecionar una opcion");
           }
           
        } while (option<0 || option>7);
        
        System.out.println("Opcion seleccionada: "+ option);
        return option;
    }
    
    
    Credentials credentials = new Credentials();
    
    public Boolean validationCredentials(){
      Boolean validation =false;
        do {            
        System.out.println("Ingrese su usuario");
        String user = readData.nextLine();
        System.out.println("Ingrese su contraseña");
        String password= readData.nextLine();
        
        if(user.equals(credentials.getUser()) && password.equals(credentials.getPassword())){
            System.out.println("Bievenido a SUPER 25");
            validation= true;
        }else{
            System.out.println("Credenciales invalidas, vuelvelas a ingresar");
        }
        
        } while (!validation);
        return validation;
        
    }
    
    
 
    
    public void setNewProducts(Integer length) {
        products= new Product[length];    
    }
   
    public void setNewCoupons(Integer length){
        coupons= new Coupon[length];
    }
    
    
    
}
