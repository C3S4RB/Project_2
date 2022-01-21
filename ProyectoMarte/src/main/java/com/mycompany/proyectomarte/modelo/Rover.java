/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.Nasa;
import com.mycompany.proyectomarte.data.CONSTANTES;
import com.mycompany.proyectomarte.data.MineralData;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author isaac
 */
public abstract class Rover implements RoverI {

    private Ubicacion ubicacion;
    private double grados;
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
       
        double nUbicaciony = ubicacion.getLatitud();
        double nUbicacionx = ubicacion.getLongitud();
       
        double hpta=2 * Math.sqrt(delta);
                      

        double newY = hpta * Math.sin(Math.toRadians(imgv.getRotate()));
        System.out.println(imgv.getRotate() + "Angle");
        double newX = hpta * Math.cos(Math.toRadians(imgv.getRotate()));
        System.out.println(grados + "grados");
        System.out.println(newY + "----" + newX);  //d*squart(2)

        if (newY == 0) {

            ubicacion.setLatitud(imgv.getLayoutY());
            ubicacion.setLongitud(newX+nUbicacionx);
        } else if (newX == 0) {
            ubicacion.setLatitud(newY+nUbicaciony);
            ubicacion.setLongitud(imgv.getLayoutX());
        } else {
            
            ubicacion.setLongitud(newX+nUbicacionx);
            
            ubicacion.setLatitud(newY+nUbicaciony);
           // ubicacion.setLongitud(newX);

        }

       imgv.setLayoutX(ubicacion.getLongitud());
        imgv.setLayoutY(ubicacion.getLatitud());

    }

    public void girar(double n) {
        imgv.setRotate(n);
        grados = n;
        ubicacion.setLatitud(imgv.getLayoutY());
        ubicacion.setLongitud(imgv.getLayoutX());
        //  imgv.setLayoutX(ubicacion.getLongitud());
        //imgv.setLayoutY(ubicacion.getLatitud());

    }

    public void dirigirse(double x, double y) {

    }

    public void sensar() {
        LocalDate fecha = LocalDate.now();
        //if(){

        List<String> minerales = MineralData.leerMineral();
        List<String> mnrl = new ArrayList<>();
        Random random = new Random();

        //List<Crater> crateres = CraterData.leerCrateres();
        for (Crater c : Nasa.getCrateres()) {
            System.out.println("AAAAA8");

            if (imgv.intersects(c.getCircle().getLayoutBounds())) {
                //  if (c.getCircle().intersects(imgv.getLayoutX(),imgv.getLayoutY(),imgv.getFitWidth(),imgv.getFitHeight())) {
                System.out.println("AAAAAAAAAAAAAAAAAAa");

                c.getCircle().setFill(Color.TRANSPARENT);
                int cantidad = random.nextInt(minerales.size()) + 1;
                for (int x = 0; x < cantidad; x++) {
                    mnrl.add(minerales.get(random.nextInt(minerales.size())));
                }

                try (BufferedWriter outputStream
                        = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "registros.txt", false))) {

                    outputStream.write(fecha + ";" + c.getNombrecrater() + ";" + mnrl);
                    //outputStream.newLine();
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException." + e.getMessage());
                }
            }
        }

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