/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Validaciones;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author cebor
 */
public class VistaExplorarController implements Initializable {

    @FXML
    private Pane panelExplorar;
    @FXML
    private TextField comdIngresado;
    @FXML
    private Pane paneRover;
    @FXML
    private TextField comandoTxt;
    @FXML
    private ComboBox<Rover> cbRover;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
        List<Rover> rovers = RoverData.leerRovers();
  
        cbRover.getItems().addAll(rovers);
    }    

    @FXML
    private void recibirComando(ActionEvent event) {
       
        String comando= comandoTxt.getText().replace(" ","").toLowerCase(); 
        
        switch (comando){
            case "avanzar":
                //rover.avanzar();
                  comdIngresado.appendText(comando);
                break;
            case "girar":
                
                  comdIngresado.appendText(comando);
                break;
            case "dirigirse":
                
                  comdIngresado.appendText(comando);
                break;
            case "sensar":
                  comdIngresado.appendText(comando);
                break;
            case "cargar":
                
                  comdIngresado.appendText(comando);
                break;
            default:
              //alerta
                 Validaciones.lanzarAlerta("No existe comando");
       }
        
    }

    @FXML
    private void cargarRover(ActionEvent event) {
        
        Rover roverChosed=cbRover.getValue();
        
        
     
    }

    
    
    }
