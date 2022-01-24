/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 */
public class Rover_Eolico extends Rover {

    public Rover_Eolico(String string, Ubicacion u) {
        super(string, u);
        super.setUrlImagen("eva.png");
        super.setTipo("eolico");
    }

    @Override
    public void cargar() {
        getImgv().setRotate(270);
    }
    //“despliegue de molinos” y el rover gira para ver hay el norte del planeta porque los vientos siempre giran de norte a sur.

}
