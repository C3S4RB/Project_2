/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import java.util.List;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author isaac
 */
public abstract class Rover implements RoverI {

    private Ubicacion ubicacion;
    private Double grados;
    private String nombreR;
    private double radioRover = 50;
    private Rectangle rectan;

    public double getRadioRover() {
        return radioRover;
    }

    public Rectangle getRectan() {
        return rectan;
    }

    public void setRectan(Rectangle rectan) {
        this.rectan = rectan;
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
        double ux = rectan.getLayoutX();

        // double uy   =rectan.getLayoutY();
    }

    @Override
    public void girar() {

    }
    
    
    public void dirigirse(double x, double y) {

    }
    

    //public void String sensar() {
        
        //if((Ubicacion.calcularDistancia(ubicacion, ubicacionCRatrer)<radioCrater ){}

    //}

    @Override
    public String toString() {
        return "Rover{" + "nombre=" + nombreR + ", ubicacion=" + ubicacion + '}';
    }

}
