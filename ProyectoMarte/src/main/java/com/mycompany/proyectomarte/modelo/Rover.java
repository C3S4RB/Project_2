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
///Fakta implementa Rover1

public abstract class Rover  {




    private Ubicacion ubicacion;
    private Double grados;
    private String nombreR;
    private String tipo;
   
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   

    public Rover(String nombreR,Ubicacion ubicacion, String tipo) {
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.nombreR = nombreR;

    }

}