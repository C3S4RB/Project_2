/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    public static List<Crater> verificacionCrateres(String ingresados){
        
        List<Crater> crateres = CraterData.cargarCrateres();
        List<String> nCrateres = new ArrayList<>();
        String[] nombresCrateres = ingresados.split(",");
        List<String> noCumplen = new ArrayList<>();
        List<Crater> cumplen = new ArrayList<>();
        for (Crater c : crateres) {
            nCrateres.add(c.getNombrecrater().toUpperCase());
        }
        for (String elemento : nombresCrateres) {
                if (nCrateres.contains(elemento.strip().toUpperCase())) {
                    int indice = nCrateres.indexOf(elemento.strip().toUpperCase()); 
                    cumplen.add(crateres.get(indice));
                } else {
                    noCumplen.add(elemento);  
                }
            }
        if(!(noCumplen.isEmpty())){
            Alert alert2 = new Alert(AlertType.ERROR);
            alert2.setContentText(noCumplen+" no son crateres");
            alert2.showAndWait();
        }else{
            return cumplen;
        }
        return null;
    }
    
    @FXML
    private void mostarRuta(MouseEvent event) {
        String ingresados = txtCrateres.getText();
        if (!(ingresados.isEmpty())) {
            List<Crater> crateresCumplen = verificacionCrateres(ingresados);
            ubicacionRover = 
        }
        
    }

    
}
