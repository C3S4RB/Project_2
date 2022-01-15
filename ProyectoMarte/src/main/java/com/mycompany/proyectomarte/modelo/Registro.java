/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ramses
 */
public class Registro implements Comparable<Registro>{
    private LocalDate fecha;
    private String crater;
    private List<String> mineralesEncontrados;

    public Registro(LocalDate fecha, String crater, List<String> mineralesEncontrados) {
        this.fecha = fecha;
        this.crater = crater;
        this.mineralesEncontrados = mineralesEncontrados;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCrater() {
        return crater;
    }

    public List<String> getMineralesEncontrados() {
        return mineralesEncontrados;
    }

    @Override
    public String toString() {
        return "Registro{" + "fecha=" + fecha + ", crater=" + crater + ", minerales encontrados=" + mineralesEncontrados+ '}';
    }
    
    @Override
    public int compareTo(Registro r) {
        int compf = fecha.compareTo(r.fecha);
        return (compf != 0) ? compf : Integer.compare(mineralesEncontrados.size(), r.mineralesEncontrados.size());
    }    
    
}
