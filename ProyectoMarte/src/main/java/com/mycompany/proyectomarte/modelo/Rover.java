/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 */

public abstract class Rover implements RoverI {

    private Ubicacion ubicacion;
    private Double grados;
    private String nombreR;
    
    
    
    public Ubicacion getUbicacion() {
        return ubicacion;

    }    
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getGrados() {
        return grados;
    }

    public void setGrados(Double grados) {
        this.grados = grados;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public Rover(String nombreR,Ubicacion ubicacion) {
        this.ubicacion =ubicacion;
        this.nombreR = nombreR;

    }

}