/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.MineralData;
import com.mycompany.proyectomarte.data.RoverData;
import java.io.IOException;
import java.util.List;

public class Nasa {

    private static List<Crater> crateres;
    private List<String> minerales;
    private static List<Rover> rovers;
    private List<Registro> registros;

    public Nasa() throws IOException {
        crateres = CraterData.cargarCrateres();
        rovers = RoverData.cargarRovers();
        minerales = MineralData.cargarMineral();
    }

    public List<String> getMinerales() {
        return minerales;
    }

    public static List<Crater> getCrateres() {
        return crateres;
    }

    public static List<Rover> getRovers() {
        return rovers;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

}
