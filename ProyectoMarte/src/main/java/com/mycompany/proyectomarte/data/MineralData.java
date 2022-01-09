/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

import static com.mycompany.proyectomarte.data.RoverData.ruta;
import com.mycompany.proyectomarte.modelo.Mineral;
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
 * @author cebor
 */
///Hice esta h*-$# pa hacer colision dentro de cada crater 
public class MineralData {

    public static String ruta = CONSTANTES.ARCHIVOS + "minerales.txt";

    public static List<Mineral> leerMineral() {
        List<Mineral> minerales = new ArrayList<>();

        try (BufferedReader bf
                = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                Mineral mineral = new Mineral(linea);
                minerales.add(mineral);
            }

        } catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los agentes");
            ex.printStackTrace();
        }

        return minerales;

    }

}
