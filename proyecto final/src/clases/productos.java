/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


public class productos {
     final private int Id;
    final private String nombre;
    final private String precio;
    
    public productos(int id,String nombre,String precio){
        this.Id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getid(){
        return this.Id;
    }
    
    public String getnombre(){
        return this.nombre;
    }
    
    public String getprecio(){
        return this.precio;
    }
}
