/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.data;

import com.mycompany.proyectomarte.modelo.Registro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramses
 */
public class RegistroData {

    public static String ruta = CONSTANTES.ARCHIVOS + "registros.txt";
    /**
     * 
     * @return 
     */
    public static List<Registro> cargarRegistros() {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader bf
                = new BufferedReader(new FileReader(ruta))) {                        
            String linea;
            while ((linea = bf.readLine()) != null) {                
                String[] l = linea.split(";");

                //l[0] = año-mes-dia
                String f = l[0].trim();
                LocalDate fecha = LocalDate.parse(f);

                //l[1] = Crater
                String crater = l[1].trim();
                
                //Lista de minerales
                //l[2] = mineral1,mineral2,...,mineralN                                               
                List<String> minerales = new ArrayList<>();
                minerales.add(l[2].trim());
                
                //Constructor de registro
                //Registro(LocalDate fecha, String crater, List<String> mineralesEncontrados)
                Registro r = new Registro(fecha, crater, minerales);
                registros.add(r);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la informacion de los registros");
        }
        return registros;
    }
    
}
