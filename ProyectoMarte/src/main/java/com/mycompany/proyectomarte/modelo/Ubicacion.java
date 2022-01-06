/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author Ramses
 */
public class Ubicacion {
    private double latitud;
    private double longitud;

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    //Calcular distancia
    //d =  ( (x2 - x1)^2 + (y2 - y1)^2 )^1/2
    public double calcularDistancia(Ubicacion u) {
        return Math.sqrt(Math.pow(u.latitud - latitud, 2) + Math.pow(u.longitud - longitud, 2));
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "latitud = " + latitud + ", longitud = " + longitud + '}';
    }

    public String toCSV() {
        return getLatitud() + "," + getLongitud();
    }
}
