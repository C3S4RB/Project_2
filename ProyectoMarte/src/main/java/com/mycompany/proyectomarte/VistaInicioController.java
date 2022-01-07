/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class VistaInicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void explorarSuperficie(MouseEvent event) {
        System.out.println("En explorar superficie");
    }

    @FXML
    private void planificarExploracion(MouseEvent event) throws IOException {
        System.out.println("En planificar exploracion");
        Parent root = App.loadFXML("vistaPlanificar");
        App.setRoot(root);
    }

    @FXML
    private void verReporte(MouseEvent event) throws IOException {
        System.out.println("En ver reporte");
        Parent root = App.loadFXML("VistaReporte");
        App.setRoot(root);
    }

    @FXML
    private void salir(MouseEvent event) {
    //se termina la aplicacion
        Platform.exit();
    }
    
}
