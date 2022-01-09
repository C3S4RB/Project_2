/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.MineralData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Mineral;
import com.mycompany.proyectomarte.modelo.Rover;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.List;
import java.util.Random;

public class Nasa {

    List<Crater> crateres;
    List<Rover> rovers;
    List<Mineral> minerales;

    public Nasa() throws IOException {
        crateres = CraterData.cargarCrateres();
        rovers = RoverData.leerRovers();
        minerales = MineralData.leerMineral();
        asignarMinerales(crateres, minerales);

    }

    public void asignarMinerales(List<Crater> crateres, List<Mineral> minerales) {

        Random random = new Random();
        for (Crater crater : crateres) { 
            for(int x=0; x<random.nextInt(minerales.size());x++){///aqui se asigna una cantidad aletoria de minerales
            crater.asignarMineral(minerales.get(random.nextInt(minerales.size())));
            ///aqui se coloca un mineral al azar a un crater
            }// la clase crater tiene un metodo asignarMineral(mineral) , lo agrega  a su lista
        }///pilas :)

    }

    public List<Crater> getCrateres() {
        return crateres;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

}
