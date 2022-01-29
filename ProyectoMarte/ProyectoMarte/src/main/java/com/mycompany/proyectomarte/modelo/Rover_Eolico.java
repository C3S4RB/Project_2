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

    public void cargar() {
        if (getBateria() != 100) {
            getImgv().setRotate(270);

            setGrados(270.0);
            super.setBateria(100);

            Validaciones.lanzarAlertaInfo("Despliege de molinos");

            Validaciones.lanzarAlertaInfo("Cargado");
        } else {
            Validaciones.lanzarAlertaInfo("Ya esta cargada");
        }
    }

}
