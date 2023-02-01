/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ipc1_s12023_practica1_202203069;

import java.util.Scanner;

/**
 *
 * @author bruce
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        SG data = new SG();
        Credentials ejecutar= new Credentials();
        System.out.println("Usuario "+ejecutar.getUser());
        System.out.println("Password "+ejecutar.getPassword());
        System.out.println("----------------------------");
        
        AddData addData = new AddData();
        if(data.validationCredentials()){
            //Show menu
            Integer opcionElegida=data.menu();
            AddData.optionss=opcionElegida;
            addData.operations(  opcionElegida);
            
        }
        
        
    }
}
