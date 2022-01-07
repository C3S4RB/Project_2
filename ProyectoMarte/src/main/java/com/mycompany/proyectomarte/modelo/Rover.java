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




    private Double pos_x;
    private Double pos_y;
    private Double grados;
    private String nombreR;
    private String tipo;
    
    public Double getPos_x() {
        return pos_x;
    }

    public void setPos_x(Double pos_x) {
        this.pos_x = pos_x;
    }

    public Double getPos_y() {
        return pos_y;
    }

    public void setPos_y(Double pos_y) {
        this.pos_y = pos_y;
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
   

    public Rover(String nombreR, Double pos_x, Double pos_y, String tipo) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.tipo = tipo;
        this.nombreR = nombreR;

    }

}