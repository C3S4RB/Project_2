/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import javafx.scene.shape.Circle;

/**
 *
 * @author Ramses
 */
public class Crater {

    //id del crater
    private String idcrater; //numero id
    //nombre del crater
    private String nombrecrater;
    //ubicacion del crater
    private Ubicacion ubicacion;
    //radio del crater
    private double radiocrater;

    private Circle circle;

    public Crater(String idcrater, String nombrecrater, Ubicacion ubicacion, double radiocrater) {
        this.idcrater = idcrater;
        this.nombrecrater = nombrecrater;
        this.ubicacion = ubicacion;
        this.radiocrater = radiocrater;
    }

    public String getIdcrater() {
        return idcrater;
    }

    public String getNombrecrater() {
        return nombrecrater;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getRadiocrater() {
        return radiocrater;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Crater{" + "nombreCrater = " + nombrecrater + "}";
    }
}
