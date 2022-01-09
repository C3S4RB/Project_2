/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import java.util.List;
import java.util.Random;

/**
 *
 * @author cebor
 */
public class Mineral {
    private String  nombreMineral;
    private int masa;//random
    
    public Mineral(String nombreMineral){
     Random random = new Random();
    this.nombreMineral=nombreMineral;
    this.masa=random.nextInt(50) ;
    }

    public String getNombreMineral() {
        return nombreMineral;
    }

    public int getMasa() {
        return masa;
    }
   
    
    
   
}
