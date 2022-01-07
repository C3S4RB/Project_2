/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

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
    public static List<Crater> leerCrateres(){
        List<Crater> crateres = new ArrayList(Arrays.asList(
        /*  aqui van los crateres
            new Causa("Operacion Matias",
                    "causa1.png",
                    "Matias tiene una patita rota que necesta operacion",
                    1000),
            new Causa("Operacion gemelos ",
                    "causa2.png",
                    "Ayudenmos a conseguir el dinero para operar gemelos ",
                    4000),
            new Causa("Casa Josefa",
                    "causa3.png",
                    "Dinero para la comida y vacunas de josefa",
                    500),
            new Causa("No dejes e ver Michu",
                    "causa4.jpeg",
                    "Dinero para trata el ojito de Michu",
                    1000)*/
        ));
        return crateres;
    }
    
    
    //metodo toString
    @Override
    public String toString() {
        return "Crater{" +"idcrater = " +idcrater+ ", nombreCrater = " +nombrecrater+ ", ubicacion = " +ubicacion+",radio = "+radiocrater+'}';
    }
    
}
