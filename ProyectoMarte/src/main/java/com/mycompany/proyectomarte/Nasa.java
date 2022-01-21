/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Registro;
import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.MineralData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;

import com.mycompany.proyectomarte.modelo.Rover;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Nasa {

    private static List<Crater> crateres;
    private List<String> minerales;
    private List<Rover> rovers;
    private List<Registro> registros;

    public Nasa() throws IOException {
        crateres = CraterData.leerCrateres();
        rovers = RoverData.leerRovers();
        minerales = MineralData.leerMineral();

        //registros = RegistroData.leerRegistros();
    }

    public List<String> getMinerales() {
        return minerales;
    }

    public static List<Crater> getCrateres() {
        return crateres;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

}
