/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.data.CONSTANTES;
import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.MineralData;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
    private String urlImagen;

    public Rover(String nombreR, Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.nombreR = nombreR;

    }

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

<<<<<<< HEAD
    public void sensar() {

        //if((Ubicacion.calcularDistancia(ubicacion, ubicacionCRatrer)<radioCrater ){}
=======
    @Override
    public void sensar() {
        LocalDate fecha = LocalDate.now();
        //if(){

        List<String> minerales = MineralData.leerMineral();
        List<String> mnrl = new ArrayList<>();
        Random random = new Random();

        List<Crater> crateres = CraterData.leerCrateres();

        for (Crater c : crateres) {
            if (imgv.intersects(c.getCircle().getLayoutBounds())) {
                for (int x = 0 ; x < random.nextInt(minerales.size()); x++) {
                    mnrl.add(minerales.get(random.nextInt(minerales.size())));
                }

                try (BufferedWriter outputStream
                        = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "registros.txt", true))) {

                    //outputStream.write(fecha + ";" + " " + ";" + mnrl);
                    //outputStream.newLine();

                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException." + e.getMessage());
                }
            }
        }

>>>>>>> f98124ea08ba8e3d496e72a1e25c377aed7a2d77
    }

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
