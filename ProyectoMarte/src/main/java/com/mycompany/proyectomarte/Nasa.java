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
import com.mycompany.proyectomarte.modelo.Mineral;
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
        asignarMinerales(crateres, minerales);
        
        //registros = RegistroData.leerRegistros();
    }

    public static void asignarMinerales(List<Crater> crateres, List<String> minerales) {

        Random random = new Random();
        for (Crater crater : crateres) {
            ///aqui se asigna una cantidad aletoria de minerales            
            for (int x = 0; x < random.nextInt(minerales.size()); x++) {
                Mineral mineral = new Mineral(minerales.get(random.nextInt(minerales.size())));
                // crater.asignarMineral(mineral);

                crater.getMinerales().add(mineral);
                ///aqui se coloca un mineral al azar a un crater
            }// la clase crater tiene un metodo asignarMineral(mineral), lo agrega  a su lista
        }///pilas

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
