/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;

import java.time.LocalDate;

/**
 *
 * @author bruce
 */
public class Sales {
    SG sg= new SG();
    Business business = new Business();
    
    
    public void operationSales(Integer option){
        
        Float discount;
        switch (option) {
            case 3:
                 //sales
                  if(SG.products[0] != null){
                      
                      
                  if(SG.businesses[0] != null){
                      Business originalBusiness[]= SG.businesses;
                      sg.setNewBusinesses((originalBusiness.length+1));
                      
                      for (int i = 0; i < originalBusiness.length; i++) {
                         SG.businesses[i] = originalBusiness[i];
                      }
                      
                      //validate quantity
                      Integer originalMatrix[][] = SG.quantityProducts;
                      
                      sg.setNewQuantityProducts(SG.businesses.length, SG.products.length); 

                        for (int i = 0; i < originalMatrix.length; i++) {
                            for (int j = 0; j < originalMatrix[i].length; j++) {
                                SG.quantityProducts[i][j] = originalMatrix[i][j];
                            }
                        }

                      
                  }else{
                      
                        sg.setNewQuantityProducts(SG.businesses.length, SG.products.length);
                  }
                  
                  
                  SG.businesses[SG.businesses.length-1]= new Business("", 0f, 0f, 0f);        
                  SG.businesses[SG.businesses.length-1].setCashierName("Bruce Castillo");
                  LocalDate date = LocalDate.now();
                  SG.businesses[SG.businesses.length-1].setDate(date.toString());
                  String nameClient = sg.getDataString("Ingrese el nombre del cliente");
                  SG.businesses[SG.businesses.length-1].setName(nameClient);
                  String nit = sg.getDataString("Ingrese el nit del cliente");
                  if (nit.equals("")){
                      nit="C/F";
                  }
                      SG.businesses[SG.businesses.length-1].setNit(nit);
                      
                  //Product List
                 if (!(SG.products.length<=0)) {
                   System.out.println("----Listado de productos----- ");
                   System.out.println("Productos encontrados: "+SG.products.length);
                  for (int i = 0; i < SG.products.length; i++) {
                      System.out.println("No. "+(i+1)+" "+SG.products[i].getName()+ " Precio: "+ SG.products[i].getPrice());
                  }
                  Boolean validationNProduct=false;
                  
                   for (int i = 0; i < SG.products.length; i++) {
                        SG.quantityProducts[SG.businesses.length-1][i] = 0;
                   } 
                   
                  do {                         
                         Integer nProduct = sg.getDataInteger("Ingrese el numero de producto que desea comprar si desea terminar escriba -1");                         
                         validationNProduct=searchProduct(nProduct);
                         if(!validationNProduct){
                             if(nProduct<0){
                                 break;
                             }else{
                             for (int i = 0; i < SG.products.length; i++) {
                                 if(nProduct== SG.products[i].getN()){
                                     Integer amountOfProductPurchased = sg.getDataInteger("Ingrese la cantidad que desea de "+SG.products[i].getName());
                                     SG.quantityProducts[SG.businesses.length-1][i]=(SG.quantityProducts[SG.businesses.length-1][i])+amountOfProductPurchased;
                                 }
                             }
                             }
                         }
                         
                     } while (true);
                  
                  //Subtotal
                    Float subtotal=0f;
                     for (int i = 0; i < SG.products.length; i++) {
                         subtotal= subtotal+(SG.products[i].getPrice()*SG.quantityProducts[SG.businesses.length-1][i]);
                     }
                     SG.businesses[SG.businesses.length-1].setSubtotal(subtotal);
                     System.out.println("El total comprado es: "+ subtotal);
                }else{
                      System.out.println("Error, no existen productos disponibles");
                      sg.initialMenu();
                      break;
                      
                  }
                  }else{
                      System.out.println("No existen productos disponibles");
                      sg.initialMenu();
                      break;
                  }
            case 4:  
                if(SG.coupons[0] !=null){
                
                String coupon= sg.getDataString("Ingrese un cupon");
                discount= searchCoupon(coupon);
                if(discount !=0){
                    if (SG.businesses.length>1) {
                        System.out.println("Actualemnte tiene: "+ SG.businesses.length+" Ventas");
                        for (int i = 0; i < SG.businesses.length; i++) {
                            System.out.println("");
                            System.out.println("---Venta No."+(i+1)+"-----");
                            System.out.println("NIT: "+ SG.businesses[i].getNit());
                            System.out.println("Nombre del cliente: "+ SG.businesses[i].getName());
                            System.out.println("Subtotal: "+ SG.businesses[i].getSubtotal());
                            System.out.println("--------------------");
                        }
                        Integer numberChange= sg.getDataInteger("Ingrese la venta que desea añadirle cupon");
                        SG.businesses[numberChange-1].setDiscount(discount);
                    }else{
                        SG.businesses[0].setDiscount(discount);    
                        
                    }
                    }
                Integer checkIn= sg.getDataInteger("¿Desea continuar para emitir una factura? 1. Si                2. No ");
                if(checkIn>=2){
                    sg.initialMenu();
                    break;
                }
                }else{
                    System.out.println("No existen cupones en el sistema, porfavor agrega uno");
                    sg.initialMenu();
                    break;
                }
                
                
                
            case 5:     
                if(validateBusiness()){
                    Integer numberChange;
                if(SG.businesses.length>1){
                    
                    System.out.println("Actualemnte tiene: "+ SG.businesses.length+" Facturas disponibles");
                    for (int i = 0; i < SG.businesses.length; i++) {
                            System.out.println("");
                            System.out.println("---Venta No."+(i+1)+"-----");
                            System.out.println("NIT: "+ SG.businesses[i].getNit());
                            System.out.println("Nombre del cliente: "+ SG.businesses[i].getName());
                            System.out.println("Subtotal: "+ SG.businesses[i].getSubtotal());
                            System.out.println("--------------------");
                        }
                            System.out.println("");
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Ingrese un numero fuera del intervalo para mostrar todas");
                            System.out.println("---------------------------------------------------------");
                            System.out.println("");
                         numberChange= sg.getDataInteger("Ingrese el numero que desea efectuar factura");
                        if(numberChange>SG.businesses.length || numberChange<SG.businesses.length){
                            for (int i = 0; i < SG.businesses.length; i++) {
                                getBill(i);
                            }
                            sg.initialMenu();
                        }else{
                                getBill(numberChange-1);
                                sg.initialMenu();
                        }
                }else{
                    getBill(0);
                    sg.initialMenu();
                }

                }
                break;
            case 6:
                if(validateBusiness()){
                    System.out.println("-----------Reporte-----------");
                    //Sort data
                    
                    for (int i = 0; i < SG.quantityProducts.length; i++) {
                        for (int j = 0; j < SG.quantityProducts[i].length; j++) {
                            for (int k = j + 1; k < SG.quantityProducts[i].length; k++) {
                                if (SG.quantityProducts[i][j] < SG.quantityProducts[i][k]) {
                                    int temp = SG.quantityProducts[i][j];
                                        SG.quantityProducts[i][j] = SG.quantityProducts[i][k];
                                        SG.quantityProducts[i][k] = temp;
                                        
                                Product tempProducts = SG.products[j];
                                SG.products[j]=SG.products[j+1];
                                SG.products[j+1]=tempProducts;
                                }
                            }
                        }
                    }   


                    Integer totalQuantity[]= new Integer[SG.quantityProducts[0].length];
                    for (int i = 0; i < SG.quantityProducts[0].length; i++) {
                        totalQuantity[i]=0;
                         for (int j = 0; j < SG.businesses.length; j++) {
                             totalQuantity[i]=totalQuantity[i]+SG.quantityProducts[j][i];    
                         }
                    }
                    
                    
                    System.out.println("----");
                    System.out.println("El reporte optimizado de todas las ventas es:");
                    System.out.println("----");
                    System.out.println(" ");
                    for (int i = 0; i < totalQuantity.length; i++) {
                        System.out.println(SG.products[i].getName()+"------> "+totalQuantity[i]);
                    }
                    
                    
                    System.out.println(" ");
                    System.out.println("---Reporte por ventas---");
                    for (int i = 0; i < SG.businesses.length; i++) {
                        System.out.println(" ");
                         System.out.println("------Reporte No. "+(i+1)+"--------");
                         for (int j = 0; j < SG.quantityProducts[i].length; j++) {
                             System.out.println(SG.products[j].getName()+" ---------> "+ SG.quantityProducts[i][j]);
                         }
                         System.out.println("---------------------------");
                         
                    }
                    
                    
                    sg.initialMenu();
                }
                break;
            default:
                System.out.println("Gracias por visitarnos");
                break;
                
        }
    }
    
    public void getBill(Integer n){
           System.out.println(SG.quantityProducts[0][0]);
                System.out.println("");
                System.out.println("---------Emision de factura NO."+(n+1)+"-------");
                System.out.println("-------------SUPER 25-------------");
                System.out.println("Cajero: "+SG.businesses[n].getCashierName());
                System.out.println("Cliente: "+ SG.businesses[n].getName());
                System.out.println("Numero de Nit: "+ SG.businesses[n].getNit());
                System.out.println("Fecha: "+ SG.businesses[n].getDate());
                System.out.println("--------Listado de productos-------");
                for (int i = 0; i < SG.products.length; i++) {
                    if(SG.quantityProducts[n][i]>0){
                    System.out.println("("+SG.quantityProducts[n][i]+")"+ SG.products[i].getName()+" --------"+SG.products[i].getPrice());
                    }                    
                }
                Float totalDiscount=SG.businesses[n].getSubtotal()*SG.businesses[n].getDiscount();
                System.out.println("Subtotal: "+ SG.businesses[n].getSubtotal());
                System.out.println("Descuento: "+ SG.businesses[n].getDiscount()+ " ---->"+" "+totalDiscount);
                System.out.println("Total: "+(SG.businesses[n].getSubtotal()-totalDiscount));
                System.out.println("-----------------------------------------");  
    
    }
    public boolean searchProduct(Integer nProduct){
       Boolean validation= false;
        
        if(nProduct> SG.products.length){
            System.out.println("Error el producto ingresado no existe");
            validation=true;
        }
      return validation;
    }
    
    public Float searchCoupon( String coupon){
        Float discount=0f;
        if(SG.coupons[0] != null){
        for (int i = 0; i < SG.coupons.length; i++) {
            if(coupon.equals(SG.coupons[i].getName())){
                if(!SG.coupons[i].getUsed()){
                System.out.println("Cupon encontrado el descuento es de: "+(SG.coupons[i].getDiscount()*100)+"%");
                
                discount= SG.coupons[i].getDiscount();
                SG.coupons[i].setUsed(true);
                    System.out.println("Cupon aplicado correctamente");
                }else{
                    System.out.println("El cupon ya fue utilizado en otra venta");
                }
            }
        }
        
        if(discount==0){
            System.out.println("Cupon no existe o invalido");
        }
        }else{
            System.out.println("No existen cupones en el sistema");
            sg.initialMenu();
        }
        return discount;
    }
    
    public  Boolean validateBusiness(){
        Boolean validation=true;
        if (SG.businesses[0]!= null) {
            if(SG.businesses[0].getCashierName().equals("")){
                validation=false;
                System.out.println("Error, no puede acceder antes debe comprar productos 111");            
                sg.initialMenu();
            }
        }else{
        System.out.println("Error, no puede acceder antes debe comprar productos");    
        validation= false;
        sg.initialMenu();
        }
        return validation;
    }
    
}
