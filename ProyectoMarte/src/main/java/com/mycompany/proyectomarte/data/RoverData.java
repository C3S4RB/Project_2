/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Rover_Eolico;
import com.mycompany.proyectomarte.modelo.Rover_Panel;
import com.mycompany.proyectomarte.modelo.Ubicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isaac
 */
public class RoverData {

    public static String ruta = CONSTANTES.ARCHIVOS + "rovers.txt";
    public static String ruta1 = CONSTANTES.ARCHIVOS + "posiciones.txt";
    
    /**
     * 
     * @return 
     */
    public static List<Rover> cargarRovers() {

        List<Rover> rovers = new ArrayList<>();
        List<Rover> roversnuevos = new ArrayList<>();

        try ( BufferedReader bf
                = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] p = linea.split(",");

                if ((p[3]).equals("solar")) {
                    Rover rover = new Rover_Panel(p[0].trim(), new Ubicacion(Double.parseDouble(p[1].trim()), Double.parseDouble(p[2].trim())));
                    rover.setGrados(Double.parseDouble(p[4].trim()));
                    rovers.add(rover);
                } else {
                    Rover rover = new Rover_Eolico(p[0].trim(), new Ubicacion(Double.parseDouble(p[1].trim()), Double.parseDouble(p[2].trim())));
                    rover.setGrados(Double.parseDouble(p[4].trim()));
                    rovers.add(rover);
                }
            }
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los rovers");
        }
        return rovers;
    }

}
