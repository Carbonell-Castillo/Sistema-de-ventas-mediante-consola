/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPC1Practice1;

/**
 *
 * @author bruce
 */
import java.util.Scanner;
public class AddData {
    //Operations
    
    
    SG sgData = new SG();
    public static Integer quantityOfNewProducts=0;
    public static Integer quantityNewValidate=0;
    public  void operations(Integer option){
        
        
        switch (option) {
            case 1:
                
                if(SG.products.length>=10){
                    Integer validationAdd= sgData.getDataInteger("Actualmente tiene "+ SG.products.length+" Agregados ¿Deseas conservarlos y agregar nuevos? \n 1. Si      2. no");
                    if(validationAdd==1){
                        quantityOfNewProducts= sgData.getDataInteger("Ingrese la cantidad de nuevos productos que desea registrar");
                        Product originalProducts[]= SG.products;
                        sgData.setNewProducts((originalProducts.length+quantityOfNewProducts));
                            quantityNewValidate=quantityOfNewProducts;
                            quantityNewValidate=SG.products.length-quantityNewValidate;
                            System.out.println("Antiga matriz columnas: "+ SG.quantityProducts[0].length);
                          sgData.newMatrix();
                          System.out.println("Nueva matriz columnas: "+ SG.quantityProducts[0].length);
                      for (int i = 0; i < originalProducts.length; i++) {
                         SG.products[i] = originalProducts[i];
                      }
                      
                    }else if(validationAdd==2){
                        Integer subOption= sgData.getDataInteger("Ten en cuenta que al borrar todos los productos las ventas se eleiminaran, ¿Deseas continuar? \n 1. Si      2. no");
                        quantityNewValidate=0;
                            if(subOption==1){
                                SG.businesses= new Business[1];
                                SG.quantityProducts= new Integer[1][1];
                                System.out.println(" ");
                                System.out.println("------------------------------");
                                System.out.println("Los datos han sido eliminados");
                                System.out.println("------------------------------");
                                System.out.println(" ");
                                addQuantityProducts();    
                            }else{
                                sgData.initialMenu();
                            }
                        
                    }else{
                        sgData.initialMenu();
                    }
                }else{
                        addQuantityProducts();
                  }
                
                
                System.out.println("Datos a registrar: "+ quantityOfNewProducts);
                
                String productName;
                Float priceProduct;
                Boolean validationProduct=false;
                
                int i=0;
                do {
                if(!validationProduct){
                    i++;
                }
                    if(i<=quantityOfNewProducts){
                        System.out.println("");
                        System.out.println("--------Regitro No."+i);
                        productName= sgData.getDataString("Ingrese el nombre del producto");
                        priceProduct = sgData.getDataFloat("Ingres el precio del producto");
                    }else{
                        System.out.println("Se llego al limite de productos permitidos para agregar");
                        sgData.initialMenu();
                        break;
                }
                validationProduct=validateDataProduct(productName, priceProduct);
                
                } while (validationProduct || i<=sgData.products.length);
                break;
            case 2:
                Boolean validationQuantityOfCoupons=true;
                do {                    
                    Integer quantityOfCoupons = sgData.getDataInteger("Ingrese la cantidad de codigos de descuento que deseas registrar");
                    if(quantityOfCoupons>=10){
                    validationQuantityOfCoupons=false;
                    sgData.setNewCoupons(quantityOfCoupons);    
                    }else{
                        System.out.println("Error, como minimo tiene permido ingresar 10 cupones");
                    }
                
                } while (validationQuantityOfCoupons);
                
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
                        System.out.println("");
                        System.out.println("--------Regitro No."+i2);
                        code= sgData.getDataString("Ingrese el codigo de descuento");
                        discount = sgData.getDataFloat("Ingres el descuento tome como formato 1 a 100");
                    }else{
                        System.out.println("Se llego al limite de cupones permitidos para agregar");
                        sgData.initialMenu();
                        break;
                    }
                    validationCoupon=validateDataCoupon(code, discount);
                } while (validationCoupon || i2<=sgData.coupons.length);
                break;
                
            default:
                Sales sales = new Sales();
                sales.operationSales(option);
                break;
        }
        
    }
    
    public void addQuantityProducts(){
    
    boolean validationQuantityOfProducts= true;
    do {                    
                    
        quantityOfNewProducts= sgData.getDataInteger("Ingrese la cantidad de productos que desea registrar");
        if(quantityOfNewProducts>=10){
            validationQuantityOfProducts=false;
            sgData.setNewProducts(quantityOfNewProducts);
        }else{
            System.out.println("Error como minimo tiene permitido ingresar 10 productos");
        }
                
    } while (validationQuantityOfProducts);
    }
    
    
    
    public Boolean validateDataProduct(String name, Float price){
        Boolean validation=false;
        //if the name exist
        
        
       
        
        for (int i=0 ; i < sgData.products.length ; i++) {
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
                    if(quantityNewValidate>0){
                        sgData.products[quantityNewValidate]= new Product((quantityNewValidate+1),name, price);
                    System.out.println("------------------------------------");
                    System.out.println("Registro del producto exitosamente No. "+ (quantityNewValidate+1));
                    System.out.println("Nombre del producto: "+ sgData.products[quantityNewValidate].getName());
                    System.out.println("Precio del producto: "+ sgData.products[quantityNewValidate].getPrice());
                    System.out.println("------------------------------------");
                    quantityNewValidate++;
                    }else{
                        sgData.products[i]= new Product((i+1),name, price);
                    System.out.println("------------------------------------");
                    System.out.println("Registro del producto exitosamente No. "+ (i+1));
                    System.out.println("Nombre del producto: "+ sgData.products[i].getName());
                    System.out.println("Precio del producto: "+ sgData.products[i].getPrice());
                    System.out.println("------------------------------------");
                    }
                    
                    break;
                }
            }
        }
        
        return validation;
    }
    
    public Boolean validateDataCoupon(String code, Float discount){

        Boolean validation=false;
        
        if(code.length()==4){
        
        //if the name exist
        for (int i = 0; i < sgData.coupons.length ; i++) {
            if(sgData.coupons[i] != null){
                if(sgData.coupons[i].getName().equals(code)){
                    System.out.println("El codigo ya existe, ingreselo nuevamente ");
                    validation=true;
                    break;
                }
            }else{
                if(discount<=0 || discount>100){
                    System.out.println("El porcentaje del descuento excede el limite ingreselo nuevamente");
                    validation=true;
                    break;
                }else{
                    sgData.coupons[i]= new Coupon(code, (discount/100), false);
                    System.out.println("------------------------------------");
                    System.out.println("Registro del Cupon exitosamente No. "+ (i+1));
                    System.out.println("Codigo: "+ sgData.coupons[i].getName());
                    System.out.println("Descuento: "+ sgData.coupons[i].getDiscount());
                    System.out.println("------------------------------------");
                    break;
                }
            }
        }
        }else{
            System.out.println("El codigo no cuenta con 4 caracteres, ingreselo nuevamente");
            validation = true;
        }
        return validation;
    }
    

}
