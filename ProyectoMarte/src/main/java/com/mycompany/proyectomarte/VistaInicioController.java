/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CONSTANTES;
import com.mycompany.proyectomarte.modelo.Rover;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    private void explorarSuperficie(MouseEvent event) throws IOException {
       ;
        Parent root = App.loadFXML("VistaExplorar");
        App.setRoot(root);
        actualizarPosicion();
    }

    @FXML
    private void planificarExploracion(MouseEvent event) throws IOException {
        System.out.println("En planificar exploracion");
        Parent root = App.loadFXML("VistaPlanificar");
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
        actualizarPosicion();
        Platform.exit();
        
    }
    public void actualizarPosicion() {
        try (BufferedWriter outputStream
                = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "rovers.txt", false))) {
            
            List<Rover> rovers = VistaExplorarController.getRovers();
            
            for (Rover r : rovers) {            
                double nx = r.getUbicacion().getLongitud();
                double ny = r.getUbicacion().getLatitud();
                outputStream.write(r.getNombreR() + "," + String.valueOf(ny) + "," + String.valueOf(nx) + "," + r.getTipo() +","+ r.getGrados()+"\n");                
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file out.txt." + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException." + e.getMessage());
        }
    }
    
}
