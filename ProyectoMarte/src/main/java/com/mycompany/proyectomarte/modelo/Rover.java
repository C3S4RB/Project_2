/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import java.util.List;
import javafx.scene.image.ImageView;
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
    private ImageView imgv;
    private static double delta = 50;
    private String urlImagen = "rover.jpg";

    public double getRadioRover() {
        return radioRover;
    }

    public ImageView getImgv() {
        return imgv;
    }

    public void setImgv(ImageView imgv) {
        this.imgv = imgv;
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
        System.out.println("1");
        double x = imgv.getLayoutX();
        System.out.println("2");
        double y = imgv.getLayoutY();
        System.out.println("3");
        double nUbicacion = x + delta;
        System.out.println("4");
        imgv.setLayoutX(nUbicacion);
        System.out.println("5");

        // double uy   =rectan.getLayoutY();
    }

    public void girar(double n) {

    }

    public void dirigirse(double x, double y) {

    }

    /*
    public String sensar(){
        
    if((Ubicacion.calcularDistancia(ubicacion, ubicacionCRatrer)<radioCrater ){}
    
    }
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Rover{" + "nombre=" + nombreR + ", ubicacion=" + ubicacion + '}';
    }

}
