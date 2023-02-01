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
public class AddData {
    //Operations
    
    public static int optionss;
    
    SG sgData = new SG();
    public  void operations(Integer option){
        
        
        switch (option) {
            case 1:
                Integer quantityOfProducts= sgData.getDataInteger("Ingrese la cantidad de productos que desea registrar");
                sgData.setNewProducts(quantityOfProducts);
                System.out.println("Datos a registrar: "+ sgData.products.length);
                
                String productName;
                Float priceProduct;
                Boolean validationProduct=false;
                
                int i=0;
                do {
                if(!validationProduct){
                    i++;
                }
                    if(i<=sgData.products.length){
                        productName= sgData.getDataString("Ingrese el nombre del producto");
                        priceProduct = sgData.getDataFloat("Ingres el precio del producto");
                    }else{
                        System.out.println("Se llego al limite de productos permitidos para agregar");
                        initialMenu();
                        break;
                }
                validationProduct=validateDataProduct(productName, priceProduct);
                
                } while (validationProduct || i<=sgData.products.length);
                break;
            case 2:
                
                Integer quantityOfCoupons = sgData.getDataInteger("Ingrese la cantidad de codigos de descuento que deseas registrar");
                sgData.setNewCoupons(quantityOfCoupons);
                System.out.println("Datos a registrar: "+ sgData.coupons.length);
                
                String code;
                Float discount;
                Boolean validationCoupon=false;
                int i2=0;
                do {   
                if(!validationCoupon){
                    i2++;
                }
                    if(i2<=sgData.coupons.length){
                        code= sgData.getDataString("Ingrese el codigo de descuento");
                        discount = sgData.getDataFloat("Ingres el descuento tome como formato 1 a 100");
                    }else{
                        System.out.println("Se llego al limite de cupones permitidos para agregar");
                        initialMenu();
                        break;
                    }
                    validationCoupon=validateDataCoupon(code, discount);
                } while (validationCoupon || i2<=sgData.coupons.length);
                break;
                
            default:
                System.out.println("Entro a default");
                throw new AssertionError();
        }
        
    }
    
    public Boolean validateDataProduct(String name, Float price){
        Boolean validation=false;
        //if the name exist
        for (int i = 0; i < sgData.products.length ; i++) {
            if(sgData.products[i] != null){
                if(sgData.products[i].getName().equals(name)){
                    System.out.println("El nombre del producto ya existe, ingreselo nuevamente");
                    validation=true;
                    break;
                }
            }else{
                if(price<=0){
                    System.out.println("El precio del producto es menor a cero, ingreselo nuevamente");
                    validation=true;
                    break;
                }else{
                    sgData.products[i]= new Product(name, price);
                    System.out.println("------------------------------------");
                    System.out.println("Registro del producto exitosamente No. "+ (i+1));
                    System.out.println("Nombre del producto: "+ sgData.products[i].getName());
                    System.out.println("Precio del producto: "+ sgData.products[i].getPrice());
                    System.out.println("------------------------------------");
                    break;
                }
            }
        }
        
        return validation;
    }
    
    public Boolean validateDataCoupon(String code, Float discount){

        Boolean validation=false;
        
        if(code.length()<=4){
        
        //if the name exist
        for (int i = 0; i < sgData.coupons.length ; i++) {
            if(sgData.coupons[i] != null){
                if(sgData.coupons[i].getName().equals(code)){
                    System.out.println("El codigo ya existe, ingreselo nuevamente ");
                    validation=true;
                    break;
                }
            }else{
                if(discount<0 || discount>100){
                    System.out.println("El porcentaje del descuento excede el limite ingreselo nuevamente");
                    validation=true;
                    break;
                }else{
                    sgData.coupons[i]= new Coupon(code, (discount/100));
                    System.out.println("------------------------------------");
                    System.out.println("Registro del producto exitosamente No. "+ (i+1));
                    System.out.println("Codigo: "+ sgData.coupons[i].getName());
                    System.out.println("Descuento: "+ sgData.coupons[i].getDiscount());
                    System.out.println("------------------------------------");
                    break;
                }
            }
        }
        }else{
            System.out.println("El codigo excede los 4 caracteres, ingreselo nuevamente");
            validation = true;
        }
        return validation;
    }
    
    public  void initialMenu(){
        Integer option= sgData.getDataInteger("¿Deseas visualizar el menu nuevamente? \n 1. Si      2. no");
        
        if(option==1){
            Integer optionMenu=sgData.menu();
            if(optionMenu==1 || optionMenu==2){
                System.out.println("Ten en cuenta que si tenias registros previos seran eliminados.");
                Integer subOption= sgData.getDataInteger("¿Aun asi quieres continuar? \n 1. Si      2. no");
                
                if(subOption==1){
                     operations(optionMenu);
                }else{
                    initialMenu();
                }
                
            }else{
                operations(option);
            }
        }else{
            System.out.println("Gracias por visitarnos");
        }
    }
}
