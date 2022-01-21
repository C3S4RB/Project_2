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
                 circle.setStroke(Color.DARKRED);
                crater.setCircle(circle);
                crateres.add(crater);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los crateres");
            ex.printStackTrace();
        }
        return crateres;
    }
    

}
