/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectomarte.modelo;

/**
 *
 * @author isaac
 * Interfaz Rover crea todos los métodos a implementar
 */
public interface RoverI {
/**
 * //mueve el robot de su posición hacia delante.
 */
    public void avanzar();
/**
 * /gira el robot g grados hacia la derecha
 * @param n recibe un double 
 */
    public void girar(double n);
/**
 * le indica al robot que debe dirigirse a la posición x,y del mapa
 * @param x  ubicacion en X double 
 * @param y ubicacion en Y double
 */
    public void dirigirse(double x, double y);
    /**
     *  El robot debe de forma automática encontrar la ruta para llegar al sitio en x,y y luego dirigirse a ese lugar 

     */
    public void sensar();//le indica al robot que debe sensar el suelo en su ubicación actual
/**
 * le indica al robot que inicie operación de recarga.
 */
    public void cargar();

}
