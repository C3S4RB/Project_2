/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import java.io.IOException;
import java.util.List;

public class Nasa {
    List<Crater> crateres;
    List<Rover> rovers;
    
    
    public Nasa() throws IOException{
        crateres = CraterData.cargarCrateres();
        rovers = RoverData.leerRovers();
    }
    
    public List<Crater> getCrateres(){
        return crateres;
    }
    public List<Rover> getRovers(){
        return rovers;
    }
    
}
