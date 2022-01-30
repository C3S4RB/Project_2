/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

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
 * Rover es la clase padre que representa la imagen dentro del mapa
 *
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
    private double ubicacionx;
    private double ubicaciony;
    private String tipo;
    private int bateria = 100;

    /**
     *
     * @param nombreR
     * @param ubicacion
     */
    public Rover(String nombreR, Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.nombreR = nombreR;
    }

    /**
     *
     * @return
     */
    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    /**
     *
     * @param nombreR
     * @param ubicacion
     */
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Ubicacion getUbicacion() {
        return ubicacion;

    }

    public double getUbicacionx() {
        return ubicacionx;
    }

    public void setUbicacionx(double ubicacionx) {
        this.ubicacionx = ubicacionx;
    }

    public double getUbicaciony() {
        return ubicaciony;
    }

    public void setUbicaciony(double ubicaciony) {
        this.ubicaciony = ubicaciony;
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

        double hpta = 2 * Math.sqrt(delta);

        double newY = hpta * Math.sin(Math.toRadians(imgv.getRotate()));
        double newX = hpta * Math.cos(Math.toRadians(imgv.getRotate()));

        if (newY == 0) {

            ubicacion.setLatitud(imgv.getLayoutY());
            ubicacion.setLongitud(newX + nUbicacionx);
        } else if (newX == 0) {
            ubicacion.setLatitud(newY + nUbicaciony);
            ubicacion.setLongitud(imgv.getLayoutX());
        } else {

            ubicacion.setLongitud(newX + nUbicacionx);

            ubicacion.setLatitud(newY + nUbicaciony);

        }

        imgv.setLayoutX(ubicacion.getLongitud());
        imgv.setLayoutY(ubicacion.getLatitud());

        int bateriaRestant = getBateria() - 1;

        setBateria(bateriaRestant);

    }

    public void girar(double n) {
        imgv.setRotate(n);
        grados = n;
        ubicacion.setLatitud(imgv.getLayoutY());
        ubicacion.setLongitud(imgv.getLayoutX());

    }

    public void dirigirse(double x, double y) {
        double hpta = Ubicacion.calcularDistancia(x, ubicacion.getLongitud(), y, ubicacion.getLatitud());
        double angulo = Math.acos((Math.abs(x - ubicacion.getLongitud())) / hpta);

        if (x < ubicacion.getLongitud() && y < ubicacion.getLatitud()) {
            imgv.setRotate(Math.toDegrees(angulo) + 180);
        } else if (x < ubicacion.getLongitud() && y > ubicacion.getLatitud()) {
            imgv.setRotate(180 - Math.toDegrees(angulo));
        } else if (x < ubicacion.getLongitud() && y < ubicacion.getLatitud()) {
            imgv.setRotate(Math.toDegrees(angulo) + 180);
        } else if (x > ubicacion.getLongitud() && y < ubicacion.getLatitud()) {
            imgv.setRotate(360 - Math.toDegrees(angulo));
        } else {
            imgv.setRotate(Math.toDegrees(angulo));
        }
        setGrados(imgv.getRotate());
        dirigirRunnable dr = new dirigirRunnable();
        Thread th = new Thread(dr);
        th.setDaemon(true);
        th.start();

    }

    public void sensar() {
        LocalDate fecha = LocalDate.now();
        List<String> minerales = MineralData.cargarMineral();
        List<String> mnrl = new ArrayList<>();
        Random random = new Random();

        for (Crater c : Nasa.getCrateres()) {

            if (interseccion(c)) {
                System.out.println(imgv.getImage().getWidth());
                System.out.println("Rover:" + imgv.getLayoutX() + ":" + imgv.getLayoutX() + ":circle" + c.getCircle().getCenterX() + "" + c.getCircle().getCenterY() + "Radio:" + c.getCircle().getRadius());
                System.out.println("LayoutX" + c.getCircle().getLayoutX() + "getX" + c.getCircle().getCenterX());
                c.getCircle().setFill(Color.TRANSPARENT);
                int cantidad = random.nextInt(minerales.size()) + 1;
                for (int x = 0; x < cantidad; x++) {
                    mnrl.add(minerales.get(random.nextInt(minerales.size())));
                }

                try (BufferedWriter outputStream
                        = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "registros.txt", true))) {

                    outputStream.write(fecha + ";" + c.getNombrecrater() + ";" + String.join(",", mnrl) + "\n");
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException." + e.getMessage());
                }
            }
        }

    }

    public void descargar() {
        boolean cd = true;
        System.out.println(getBateria() + "%");

        if (bateria == 20) {
            Validaciones.lanzarAlertaInfo("Batería baja: " + bateria + "%" + "\nRecomienda cargar");
            cd = true;

        }

    }

    public boolean interseccion(Crater crater) {
        if (Ubicacion.calcularDistancia(ubicacion, crater.getUbicacion()) <= crater.getRadiocrater()) {
            return true;
        } else {
            return false;
        }
    }

    class dirigirRunnable implements Runnable {

        @Override
        public void run() {
            try {
                if (ubicacionx > getUbicacion().getLongitud() && ubicaciony > getUbicacion().getLatitud()) {
                    while (!(ubicacionx <= ubicacion.getLongitud() && ubicaciony <= ubicacion.getLatitud())) {
                        avanzar();
                        Thread.sleep(500);
                    }
                } else if (ubicacionx < getUbicacion().getLongitud() && ubicaciony > getUbicacion().getLatitud()) {
                    while (!(ubicacionx >= ubicacion.getLongitud() && ubicaciony <= ubicacion.getLatitud())) {
                        avanzar();

                        Thread.sleep(500);
                    }
                } else if (ubicacionx < getUbicacion().getLongitud() && ubicaciony < getUbicacion().getLatitud()) {
                    while (!(ubicacionx >= ubicacion.getLongitud() && ubicaciony >= ubicacion.getLatitud())) {
                        avanzar();

                        Thread.sleep(500);
                    }
                } else if (ubicacionx > getUbicacion().getLongitud() && ubicaciony < getUbicacion().getLatitud()) {
                    while (!(ubicacionx <= ubicacion.getLongitud() && ubicaciony >= ubicacion.getLatitud())) {
                        avanzar();

                        Thread.sleep(500);
                    }
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
