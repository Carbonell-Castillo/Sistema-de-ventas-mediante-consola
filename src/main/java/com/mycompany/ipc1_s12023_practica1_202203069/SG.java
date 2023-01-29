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
    
    Scanner readData = new Scanner(System.in);
    //menu
    public Integer menu(){
        Integer option=0;
        do {            
           System.out.println("----Menu---");
           System.out.println("Seleccione una opcion");
           System.out.println("1. Menu Inicial");
           System.out.println("2. Agregar nuevos productos al sistema");
           System.out.println("3. Agregar nuevos codigos promocionales de descuento al sistema");
           System.out.println("4. Realizar ventas");
           System.out.println("5. Aplicar descuentos a las compras con codigos promocionales");
           System.out.println("6. Emitir factura");
           option= readData.nextInt();
        } while (option<0 && option>7);
        
        return option;
    }
    
    public static void initialMenu(){
           System.out.println("");
    }
    
    Credentials credentials = new Credentials();
    
    public Boolean validationData(String user, String password){
        Boolean validation= false;
        if(credentials.getUser().equals(user) && credentials.getPassword().equals(password)){
            validation= true;
        }
        if(validation){
            System.out.println("Bienvenido a SUPER 25");
        }else{
            System.out.println("Usuario o contraseña incorrecta, intente nuevamente.");
        }
        return validation;
    }
    
}
