/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.data.CraterData;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Ramses
 */
public class Validaciones {

    public static List<Crater> validarCrateres(String ingresados) {

        List<Crater> crateres = CraterData.cargarCrateres();
        List<String> nCrateres = new ArrayList<>();
        String[] nombresCrateres = ingresados.split(",");
        List<String> noCumplen = new ArrayList<>();
        List<Crater> cumplen = new ArrayList<>();
        for (Crater c : crateres) {
            nCrateres.add(c.getNombrecrater().toUpperCase());
        }
        for (String elemento : nombresCrateres) {
            if (nCrateres.contains(elemento.strip().toUpperCase())) {
                int indice = nCrateres.indexOf(elemento.strip().toUpperCase());
                cumplen.add(crateres.get(indice));
            } else {
                noCumplen.add(elemento);
            }
        }
        if (!(noCumplen.isEmpty())) {            
            lanzarAlerta(noCumplen + " no son crateres");            
        } else {
            return cumplen;
        }
        return null;
    }

    //Validamos que el mineral exista
    /*
    public static boolean validarMineral(String m){
        //List<
        return 
    }*/

    //Metodo para validad que la fecha sea valida
    public static boolean validarFecha(String texto) {
        return texto.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]([012][0-9])\\d{2}$");
    }

    public static void lanzarAlerta(String mensaje) {
        //Alerta de tipo error
        Alert alert = new Alert(AlertType.ERROR);
        //Mostramos un mensaje con el contenido:
        alert.setContentText(mensaje);
        //Muestra la alerta
        alert.showAndWait();
    }
}
