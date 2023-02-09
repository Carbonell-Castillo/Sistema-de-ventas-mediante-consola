/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPC1Practice1;

/**
 *
 * @author bruce
 */
public class Identity {
    private String name;
    private String nit;
    private String date;

    public Identity(){
        name="";
        nit="";
        date="";
    }
    public Identity(String name, String nit, String date) {
        this.name = name;
        this.nit = nit;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
