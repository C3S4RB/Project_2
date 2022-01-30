/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 * Rover Panel extiende de Rover
 */
public class Rover_Panel extends Rover {

    public Rover_Panel(String string, Ubicacion u) {
        super(string, u);
        super.setUrlImagen("wallie.png");
        super.setTipo("solar");
    }

    /**
     *Método cargar de la clase Rover_Panel  se encarga de recargar la bateria del rover
     */
    @Override
    public void cargar() {
        setUbicacionx(100);
        setUbicaciony(100);
        dirigirse(100, 100);
        if (getBateria() != 100) {
            super.setBateria(101);

            Validaciones.lanzarAlertaInfo("Cargando paneles");
            Validaciones.lanzarAlertaInfo("Cargado " + getBateria() + "%");
            System.out.println("Cargado " + getBateria() + "%");
        } else {
            Validaciones.lanzarAlertaInfo("Ya esta cargada");
        }
    }

}
