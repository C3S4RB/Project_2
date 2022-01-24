/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.VistaExplorarController;

/**
 *
 * @author isaac
 */
public class Rover_Panel extends Rover {

    public Rover_Panel(String string, Ubicacion u) {
        super(string, u);
        super.setUrlImagen("wally.png");
        super.setTipo("solar");
    }

    @Override
    public void cargar() {
        
        setUbicacionx(100);
        setUbicaciony(100);
        dirigirse(100, 100);
        
    }//llama al metodo dirigirse (100,110) y un mensaje mensaje “abriendo panales” 

}
