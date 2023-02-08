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
                  SG.businesses[0]= new Business("", 0f, 0f, 0f);        
                  SG.businesses[0].setCashierName("Bruce Castillo");
                  LocalDate date = LocalDate.now();
                  SG.businesses[0].setDate(date.toString());
                  String nameClient = sg.getDataString("Ingrese el nombre del cliente");
                  SG.businesses[0].setName(nameClient);
                  String nit = sg.getDataString("Ingrese el nit del cliente");
                  if (nit.equals("")){
                      nit="C/F";
                  }
                      SG.businesses[0].setNit(nit);
                      
                  //Product List
                 if (!(SG.products.length<=0)) {
                   sg.setNewQuantityProducts(SG.products.length);
                   System.out.println("----Listado de productos----- ");
                   System.out.println(SG.products.length);
                  for (int i = 0; i < SG.products.length; i++) {
                      System.out.println("No. "+(i+1)+" "+SG.products[i].getName()+ " Precio: "+ SG.products[i].getPrice());
                  }
                  Boolean validationNProduct=false;
                  
                   for (int i = 0; i < SG.quantityProducts.length; i++) {
                        SG.quantityProducts[i] = 0;
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
                                     SG.quantityProducts[i]=SG.quantityProducts[i]+1;
                                 }
                             }
                             }
                         }
                         
                     } while (true);
                  
                  //Subtotal
                    Float subtotal=0f;
                     for (int i = 0; i < SG.products.length; i++) {
                         subtotal= subtotal+(SG.products[i].getPrice()*SG.quantityProducts[i]);
                     }
                     SG.businesses[0].setSubtotal(subtotal);

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
                
                SG.businesses[0].setDiscount(discount);
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
                
                System.out.println("");
                System.out.println("---------Emision de factura-------");
                System.out.println("-------------SUPER 25-------------");
                System.out.println("Cajero: "+SG.businesses[0].getCashierName());
                System.out.println("Cliente: "+ SG.businesses[0].getName());
                System.out.println("Numero de Nit: "+ SG.businesses[0].getNit());
                System.out.println("Fecha: "+ SG.businesses[0].getDate());
                System.out.println("--------Listado de productos-------");
                for (int i = 0; i < SG.products.length; i++) {
                    if(SG.quantityProducts[i]>0){
                    System.out.println("("+SG.quantityProducts[i]+")"+ SG.products[i].getName()+" --------"+SG.products[i].getPrice());
                    }                    
                }
                Float totalDiscount=SG.businesses[0].getSubtotal()*SG.businesses[0].getDiscount();
                System.out.println("Subtotal: "+ SG.businesses[0].getSubtotal());
                System.out.println("Descuento: "+ SG.businesses[0].getDiscount()+ " ---->"+" "+totalDiscount);
                System.out.println("Total: "+(SG.businesses[0].getSubtotal()-totalDiscount));
                System.out.println("-----------------------------------------");
                sg.initialMenu();
                }
                break;
            case 6:
                if(validateBusiness()){
                    System.out.println("-----------Reporte-----------");
                    //Sort data
                    boolean isSorted = false;

                    while (!isSorted) {
                        isSorted = true;
                        for (int i = 0; i < SG.quantityProducts.length - 1; i++) {
                            if (SG.quantityProducts[i] < SG.quantityProducts[i + 1]) {
                                int temp = SG.quantityProducts[i];
                                SG.quantityProducts[i] = SG.quantityProducts[i + 1];
                                SG.quantityProducts[i + 1] = temp;
                                
                                //sort product
                                Product tempProducts = SG.products[i];
                                SG.products[i]=SG.products[i+1];
                                SG.products[i+1]=tempProducts;
                                isSorted = false;
                            }
                        }
                    }
                    
                    for (int i = 0; i < SG.products.length; i++) {
                        System.out.println(SG.products[i].getName()+" ---------> "+ SG.quantityProducts[i]);
                    }
                    System.out.println("---------------------------");
                    sg.initialMenu();
                }
                break;
            default:
                throw new AssertionError();
        }
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
                System.out.println("Cupon encontrado el descuento es de: "+(SG.coupons[i].getDiscount()*100)+"%");
                System.out.println("Cupon aplicado exitosamente");
                discount= SG.coupons[i].getDiscount();
            }
        }
        if(discount==0){
            System.out.println("Cupon invalido");
            
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
