/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Ubicacion;
import com.mycompany.proyectomarte.modelo.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class VistaPlanificarController implements Initializable {

    @FXML
    private GridPane gridRuta;
    @FXML
    private TextField txtCrateres;
    @FXML
    private ComboBox<Rover> cbRovers;
    
        Ubicacion ubicacionMenor ;
    Crater craterMenor ;
    ArrayList<String> rutaOptima = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Rover> rovers = RoverData.leerRovers();
        cbRovers.getItems().addAll(rovers);

        /*
        int contador = 1;
        for (Donacion d : donaciones) {

            Label lnombre = new Label(d.getDonador());
            gridReporte.addRow(contador, lnombre);

            Label lnombre2 = new Label(String.valueOf(d.getMontoDonacion()));
            gridReporte.addRow(contador, lnombre2);
            Label lnombre3 = new Label(d.getCausa().getNombre());
            gridReporte.addRow(contador, lnombre3);
            contador += 1;
        }*/
    }
        public void rutasOptimas(String craterEtiquetador){
        rutaOptima.add(craterEtiquetador);

    }
    public Crater darEtiquetaUbicacionMenor(List<Crater> crateresCumplen,Rover roverSeleccionado){
        for(Crater c : crateresCumplen){         
                double distanciaMayor = Double.MAX_VALUE;
                double distanciaMenor = Ubicacion.calcularDistancia(c.getUbicacion(),roverSeleccionado.getUbicacion());
                if(distanciaMenor<=distanciaMayor){
                    distanciaMayor = Ubicacion.calcularDistancia(c.getUbicacion(),roverSeleccionado.getUbicacion());
                    roverSeleccionado.setUbicacion(c.getUbicacion());
                    craterMenor = c;
                }
    }
        return craterMenor;
    }
    @FXML
    private void mostarRuta(MouseEvent event) {
        String ingresados = txtCrateres.getText();
        Rover roverSeleccionado = cbRovers.getValue();

        if (!(ingresados.isEmpty()) && roverSeleccionado != null) {
            List<Crater> crateresCumplen = Validaciones.validarCrateres(ingresados);
            while (!(crateresCumplen.isEmpty())) {
                Crater craterEtiquetado = darEtiquetaUbicacionMenor(crateresCumplen, roverSeleccionado);
                rutasOptimas(craterEtiquetado.getNombrecrater());
                crateresCumplen.remove(craterEtiquetado);
            }

        }

        int contador = 1;
        for (String s : rutaOptima) {

            Label lcrater = new Label(s);
            gridRuta.addRow(contador, lcrater);
            contador += 1;
        }
        contador = 1;
    }

    @FXML
    private void regresar(MouseEvent event) {
        //redirigir a la ventana inicio
        Parent root;
        try {
            root = App.loadFXML("VistaInicio");
            //usar ese contenedor raiz en la escena principal
            App.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
