/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Crater;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        List<Crater> donaciones = App.getFundacion().getDonaciones();
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

    @FXML
    private void mostarRuta(MouseEvent event) {
    }
    
}
