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

    private String nombreMineral;
    private int masa;//random

    public Mineral(String nombreMineral) {        
        this.nombreMineral = nombreMineral;
        Random random = new Random();
        this.masa = random.nextInt(50);
    }

    public String getNombreMineral() {
        return nombreMineral;
    }

    public int getMasa() {
        return masa;
    }

    public static void mostrarMinerales(List<Mineral> minerales) {
        for (Mineral m : minerales) {
            System.out.println(m.getNombreMineral());
        }
    }
    
    

    @Override
    public String toString() {
        return "Mineral{" + "nombreMineral = " + nombreMineral + ", masa = " + masa + '}';
    }

}
