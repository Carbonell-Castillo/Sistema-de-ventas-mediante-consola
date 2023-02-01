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
        Integer quantityProducts[] = new Integer[SG.products.length];
        Float discount;
        switch (option) {
            case 3:
                 //sales
                  business.setCashierName("Bruce Castillo");
                  LocalDate date = LocalDate.now();
                  business.setDate(date.toString());
                  String nameClient = sg.getDataString("Ingrese el nombre del cliente");
                  business.setName(nameClient);
                  String nit = sg.getDataString("Ingrese el nit del cliente");
                  if (nit.equals("")){
                      nit="C/F";
                  }
                      business.setNit(nit);
                      System.out.println("Listado de productos: ");
                      System.out.println(SG.products.length);
                      
                  //Product List
                 if (!(SG.products.length<=0)) {
                   System.out.println("----Listado de productos----- ");
                   System.out.println(SG.products.length);
                  for (int i = 0; i < SG.products.length; i++) {
                      System.out.println("No. "+(i+1)+" "+SG.products[i].getName()+ " Precio: "+ SG.products[i].getPrice());
                  }
                  Boolean validationNProduct=false;
                  
                   for (int i = 0; i < quantityProducts.length; i++) {
                        quantityProducts[i] = 0;
                   } 
                   
                  do {                         
                         Integer nProduct = sg.getDataInteger("Ingrese el numero de producto que desea comprar \n si desea terminar escriba -1");                         
                         validationNProduct=searchProduct(nProduct);
                         if(!validationNProduct){
                             if(nProduct<0){
                                 break;
                             }else{
                             for (int i = 0; i < SG.products.length; i++) {
                                 if(nProduct== SG.products[i].getN()){
                                     quantityProducts[i]=quantityProducts[i]+1;
                                 }
                             }
                             }
                         }
                         
                     } while (true);
                  
                  //Subtotal
                    Float subtotal=0f;
                     for (int i = 0; i < SG.products.length; i++) {
                         subtotal= subtotal+(SG.products[i].getPrice()*quantityProducts[i]);
                     }
                     business.setSubtotal(subtotal);
                }else{
                      System.out.println("Error, no existen productos disponibles");
                      sg.initialMenu();
                      break;
                      
                  }
                  
            case 4:  
                String coupon= sg.getDataString("Ingrese un cupon");
                discount= searchCoupon(coupon);
                System.out.println("Cupon aplicado exitosamente");
                business.setDiscount(discount);
                Integer checkIn= sg.getDataInteger("¿Desea continuar para emitir una factura? \n1. Si                 \n2. No ");
                if(checkIn>=2){
                    sg.initialMenu();
                    break;
                }
                
            case 5:      
                System.out.println("");
                System.out.println("---------Emision de factura-------");
                System.out.println("-------------SUPER 25-------------");
                System.out.println("Cajero: "+business.getCashierName());
                System.out.println("Cliente: "+ business.getName());
                System.out.println("Numero de Nit: "+ business.getNit());
                System.out.println("Fecha: "+ business.getDate());
                System.out.println("--------Listado de productos-------");
                for (int i = 0; i < SG.products.length; i++) {
                    if(quantityProducts[i]>0){
                    System.out.println("("+quantityProducts[i]+")"+ SG.products[i].getName()+" --------"+SG.products[i].getPrice());
                    }                    
                }
                Float totalDiscount=business.getSubtotal()*business.getDiscount();
                System.out.println("Subtotal: "+ business.getSubtotal());
                System.out.println("Descuento: "+ business.getDiscount()+ " ---->"+" "+totalDiscount);
                System.out.println("Total: "+(business.getSubtotal()-totalDiscount));
                System.out.println("-----------------------------------------");
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
        for (int i = 0; i < SG.coupons.length; i++) {
            if(coupon.equals(SG.coupons[i].getName())){
                System.out.println("Cupon encontrado el descuento es de: "+(SG.coupons[i].getDiscount()*100)+"%");
                discount= SG.coupons[i].getDiscount();
            }
        }
        return discount;
    }
    
}
