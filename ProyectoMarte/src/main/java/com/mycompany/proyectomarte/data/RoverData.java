/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

import com.mycompany.proyectomarte.modelo.Rover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author isaac
 */
public class RoverData {
    public static String ruta = CONSTANTES.ARCHIVOS + "/rovers-1.txt";
    
    
    public static List<Rover> leerRovers() {
   List<Rover> rovers = new ArrayList<>();
   try( BufferedReader bf = 
                new BufferedReader(new FileReader(ruta)) ){
            String linea;
            while((linea = bf.readLine())!=null){
                String[] p = linea.split(",");
                Rover rover =new Rover(p[0],Double.parseDouble(p[1]),Double.parseDouble(p[2]),p[3]) {};
                rovers.add(rover);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los agentes");
            ex.printStackTrace();
        }
        return rovers;
    
    }

}