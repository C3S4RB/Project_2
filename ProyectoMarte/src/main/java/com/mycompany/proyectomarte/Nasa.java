/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Crater;
import java.util.List;

public class Nasa {
    List<Crater> crateres;
    List<Rover> rovers;
    public Nasa(){
        crateres = Crater.leerCrateres();
        rovers = Rover.leerRovers();
    }
    
    public void guardarCrater(Crater c){
        crateres.add(c);
    }
    
    public List<Crater> getDonaciones(){
        return crateres;
    }
    
}
