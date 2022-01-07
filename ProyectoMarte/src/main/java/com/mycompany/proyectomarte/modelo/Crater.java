/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.data.CONSTANTES;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    public Crater(String idcrater, String nombrecrater, Ubicacion ubicacion, double radiocrater){
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
    
    //metodo toString
    @Override
    public String toString() {
        return "Crater{" +"idcrater = " +idcrater+ ", nombreCrater = " +nombrecrater+ ", ubicacion = " +ubicacion+",radio = "+radiocrater+'}';
    }
    
}
