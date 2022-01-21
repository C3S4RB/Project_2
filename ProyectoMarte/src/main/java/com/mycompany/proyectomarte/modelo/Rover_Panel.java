/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 */
public class Rover_Panel extends Rover {

    public Rover_Panel(String string, Ubicacion u) {
        super(string, u);
        super.setUrlImagen("wally.png");
    }

    public void cargar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//llama al metodo dirigirse (100,110) y un mensaje mensaje “abriendo panales” 

}
