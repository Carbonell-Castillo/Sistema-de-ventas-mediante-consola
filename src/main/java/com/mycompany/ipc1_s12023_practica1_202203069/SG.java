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
    
    public static Product[] products = new Product[1];
    public static Coupon[] coupons = new Coupon[1];
    public static Business[] businesses= new Business[1];
    
    public static Integer quantityProducts[][]= new Integer[1][1];
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
           System.out.println("6. Emitir reporte");
            System.out.println("7. salir");
           option= readData.nextInt();
           if(option<0 || option>7){
               System.out.println("Opcion seleccionada incorrecta, vuelva a selecionar una opcion");
           }
           
        } while (option<0 || option>7);
        System.out.println("");
        System.out.println("Opcion seleccionada: "+ option);
        return option;
    }
   public void conditionalMenu(Integer optionMenu){
       AddData addData = new AddData();
       
       System.out.println("Ten en cuenta que si tenias registros previos seran eliminados.");
       readData.nextLine();
       Integer subOption= getDataInteger("¿Aun asi quieres continuar? \n 1. Si      2. no");       
       
        if(subOption==1){
            addData.operations(optionMenu);
        }else{
             initialMenu();
        }
   }
    public  void initialMenu(){
       
       Sales sales = new Sales();
        System.out.println("");
        Integer option= getDataInteger("¿Deseas visualizar el menu nuevamente? \n 1. Si      2. no");
        
        if(option==1){
            Integer optionMenu=menu();
            if(optionMenu==1 || optionMenu==2){
                conditionalMenu(optionMenu);
            }else{
                sales.operationSales(optionMenu);
            }
        }else{
            System.out.println("Gracias por visitarnos");
        }
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
    
    public void setNewQuantityProducts(Integer length1, Integer length2){
        quantityProducts= new Integer[length1][length2];
    }
    
    public void setNewBusinesses(Integer length){
        businesses = new Business[length];
    }
    
}
