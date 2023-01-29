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
        Scanner readData = new Scanner(System.in);
        SG validation = new SG();
        Credentials ejecutar= new Credentials();
        System.out.println("Usuario "+ejecutar.getUser());
        System.out.println("Password "+ejecutar.getPassword());
        
        Boolean validationUserData=true;
        
        do {            
        System.out.println("Ingrese su usuario");
        String user = readData.nextLine();
        System.out.println("Ingrese su contraseña");
        String password= readData.nextLine();
        validationUserData=validation.validationData(user, password);
        } while (!validationUserData);
     
        
        
        
        
        
    }
}
