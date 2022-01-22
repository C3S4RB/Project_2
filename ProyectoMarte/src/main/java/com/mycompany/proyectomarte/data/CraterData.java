/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Ubicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Ramses
 */
public class CraterData {

    public static String ruta = CONSTANTES.ARCHIVOS + "crateres_info.txt";
    public static String ruta2 = CONSTANTES.ARCHIVOS + "registros.txt";

    public static List<Crater> leerCrateres() {
        List<Crater> crateres = new ArrayList<>();

        try (BufferedReader bf
                = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bf.readLine()) != null) {

                //Constructor Crater tiene
                //int idcrater, String nombrecrater, Ubicacion ubicacion, double radiocrater
                //Contructor Ubicacion tiene 
                //double latitud, double longitud
                String[] c = linea.split(",");
                //c1 es el nombre del crater
                Ubicacion ubicacion = new Ubicacion(Double.valueOf(c[3]), Double.valueOf(c[2]));
                Crater crater = new Crater(c[0], c[1], ubicacion, Double.valueOf(c[4]));
                Circle circle = new Circle(crater.getRadiocrater(), Color.RED);
                circle.setCenterX(Double.valueOf(c[2]));
                circle.setCenterY(Double.valueOf(c[3]));

                crater.setCircle(circle);
                crater.getCircle().setStroke(Color.DARKRED);

                crateres.add(crater);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los crateres");
            ex.printStackTrace();
        }

        listaSensados();
        return crateres;
    }

    public static List<Crater> pintar(List<String> crateresNSensado, List<Crater> crateres) {
        List<Crater> crateresF = new ArrayList<>();
        for (Crater cra : crateres) {
            for (String craterSensado : crateresNSensado) {

                if (cra.getNombrecrater().equals(craterSensado)) {
                    System.out.println(craterSensado);
                    cra.getCircle().setStroke(Color.TRANSPARENT);

                }

            }
            crateresF.add(cra);

        }
        return crateresF;
    }

    public static List<String> listaSensados() {
        try (BufferedReader bfCRegistro
                = new BufferedReader(new FileReader(ruta2))) {
            List<String> crateresNSensado = new ArrayList<>();

            String linea;
            while ((linea = bfCRegistro.readLine()) != null) {
                String craterSensado = linea.split(";")[1];

                if (!crateresNSensado.contains(craterSensado)) {
                    crateresNSensado.add(craterSensado);

                }
            }
            return crateresNSensado;

        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los crateres");
            ex.printStackTrace();
        }
        return null;
        
    }

}
