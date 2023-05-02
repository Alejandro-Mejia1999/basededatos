/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import formularios.login;

/**
 *
 * @author chandy
 */
public class ProyectoFinal {

    public static void main(String[] args) {
      conexion m1=new conexion();
      login v1=new login();
      v1.setVisible(true);
      m1.getConexion();
    }
    
}
