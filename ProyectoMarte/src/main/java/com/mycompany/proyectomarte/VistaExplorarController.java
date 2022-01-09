/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
        
        
    }    

    @FXML
    private void recibirComando(ActionEvent event) {
       
        String comando= comandoTxt.getText().replace(" ","").toLowerCase()+"\n"; 
        
        switch (comando){
            case "avanzar"+"\n":
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

    
    
    }
