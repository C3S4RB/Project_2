/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import java.util.List;

/**
 *
 * @author isaac
 */
public abstract class Rover implements RoverI {

    private Ubicacion ubicacion;
    private Double grados;
    private String nombreR;
    private double radioRover = 50;

    public double getRadioRover() {
        return radioRover;
    }

    public void setRadioRover(double radioRover) {
        this.radioRover = radioRover;
    }

    public List<Crater> getCrateresExplotados() {
        return crateresExplotados;
    }

    public void setCrateresExplotados(List<Crater> crateresExplotados) {
        this.crateresExplotados = crateresExplotados;
    }

    private List<Crater> crateresExplotados;

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

    public Rover(String nombreR, Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.nombreR = nombreR;

    }

    @Override
    public void avanzar() {
        if (ubicacion.getLatitud() == 5  ) {
            
            
    } }
    @Override
    public void girar(){
    
    
    }
    
    
    public void dirigirse(double x,double y){
    
    
    }

   

}
