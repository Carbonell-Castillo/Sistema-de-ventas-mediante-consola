/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;

/**
 *
 * @author bruce
 */
public class SG {
    //menu
    public static void menu(){
           System.out.println("----Menu---");
           System.out.println("Seleccione una opcion");
           System.out.println("1. Agregar nuevos productos");
           System.out.println("2. Agrega cupones de descuento");
           System.out.println("3. Realizar ventas");
           System.out.println("4. Realizar reporte");
    }
    
    
    Credentials credentials = new Credentials();
    
    public Boolean validationData(String user, String password){
        Boolean validation= false;
        if(credentials.getUser().equals(user) && credentials.getPassword().equals(password)){
            validation= true;
        }
        if(validation){
            System.out.println("Todo bien");
        }else{
            System.out.println("Incorrecto");
        }
        return validation;
    }
    
}
