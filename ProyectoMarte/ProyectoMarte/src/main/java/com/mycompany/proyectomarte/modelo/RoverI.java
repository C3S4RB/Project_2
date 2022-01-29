/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 */
public interface RoverI {

    public void avanzar();///mueve el robot de su posición hacia delante.

    public void girar(double n);///gira el robot g grados hacia la derecha

    public void dirigirse(double x, double y);///le indica al robot que debe dirigirse a la posición x,y 
    //del mapa. El robot debe de forma automática encontrar la ruta para llegar al sitio en x,y y luego dirigirse a eselugar 

    public void sensar();//le indica al robot que debe sensar el suelo en su ubicación actual

    public void cargar();//le indica al robot que inicie operación de recarga.

}
