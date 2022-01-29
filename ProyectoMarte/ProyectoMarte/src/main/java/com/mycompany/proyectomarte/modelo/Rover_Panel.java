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
        super.setTipo("solar");
    }

    public void cargar() {
        setUbicacionx(100);
        setUbicaciony(100);
        dirigirse(100, 100);
        if(getBateria()!=100){
        super.setBateria(110);

       

        Validaciones.lanzarAlertaInfo("Cargando paneles");

        Validaciones.lanzarAlertaInfo("Cargado " + getBateria() + "%");
         System.out.println("cargado " + getBateria() + "%");
}else{
        Validaciones.lanzarAlertaInfo("Ya esta cargada");
        }
    }

}
