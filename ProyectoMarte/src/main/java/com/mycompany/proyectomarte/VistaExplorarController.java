/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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
    @FXML
    private Rectangle paneRoverr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        List<Rover> rovers = RoverData.leerRovers();

        cbRover.getItems().addAll(rovers);
        cbRover.getValue().setRectan(paneRoverr);

        for (Crater crater : Nasa.getCrateres()) {

            Circle c = new Circle(crater.getRadiocrater(), Color.RED);
            c.setStroke(Color.DARKRED);
            c.setFill(Color.TRANSPARENT);

            Label l = new Label(crater.getNombrecrater());
            StackPane st = new StackPane();
            double d = 2 * c.getRadius();
            if (panelExplorar.getPrefHeight() - d > crater.getUbicacion().getLongitud() && panelExplorar.getPrefWidth() - d > crater.getUbicacion().getLatitud()) {
                st.getChildren().addAll(c, l);
                panelExplorar.getChildren().addAll(st);
                st.setLayoutX(crater.getUbicacion().getLatitud());
                st.setLayoutY(crater.getUbicacion().getLongitud());
                crater.setCircle(c);
            }
        }
    }

    @FXML
    private void recibirComando(ActionEvent event) {

        String comando = comandoTxt.getText().replace(" ", "").toLowerCase();

        //if (comando) {
        //}
        switch (comando) {
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
                cbRover.getValue().avanzar();

                break;
            case "girar;90":
                comdIngresado.appendText(comando);
                cbRover.getValue().girar();
                break;
            case "dirigirse;12,5":

                comdIngresado.appendText(comando);
                cbRover.getValue().dirigirse();
                break;
                /*
            case "sensar":
                comdIngresado.appendText(comando);
                cbRover.getValue().sensar();
                break;
                */
            case "cargar":
                comdIngresado.appendText(comando);
                cbRover.getValue().cargar();
                break;
            default:
                //alerta
                Validaciones.lanzarAlerta("No existe comando");
        }

    }

    @FXML
    private void cargarRover(ActionEvent event) {

        Rover roverChosed = cbRover.getValue();

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
        Rover roverChosed = cbRover.getValue();
    }

}
