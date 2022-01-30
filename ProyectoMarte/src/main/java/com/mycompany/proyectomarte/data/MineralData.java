/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

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

    public static List<String> cargarMineral() {
        List<String> strMinerales = new ArrayList<>();

        try (BufferedReader bf
                = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                strMinerales.add(linea.trim());
            }
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los minerales");
        }
        return strMinerales;
    }

}
