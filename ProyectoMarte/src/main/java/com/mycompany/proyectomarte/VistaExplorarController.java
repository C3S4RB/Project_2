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
import java.io.InputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    private TextField comandoTxt;
    @FXML
    private ComboBox<Rover> cbRover;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("entra");
        List<Rover> rovers = RoverData.leerRovers();

        cbRover.getItems().addAll(rovers);

        for (Crater crater : Nasa.getCrateres()) {

            Circle c = new Circle(crater.getRadiocrater(), Color.RED);
            c.setStroke(Color.DARKRED);
            //c.setFill(Color.TRANSPARENT);

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

    }//vpaneRover.getPrefHeight

    @FXML
    private void recibirComando(ActionEvent event) {

        String comando = comandoTxt.getText().replace(" ", "").toLowerCase();

        String[] comand = comando.split(":");

        switch (comand[0]) {
            case "avanzar":
                if (limites()) {
                    cbRover.getValue().avanzar();
                }
                comdIngresado.appendText(comando);

                break;
            case "girar:90":

                comdIngresado.appendText(comando);
                //comand[1]
                cbRover.getValue().girar(Double.parseDouble(comand[1]));

                break;
            case "dirigirse:15;125":
                String[] coman = comand[1].split(";");
                //x=coman[0]
                //y=coman[1]
                cbRover.getValue().dirigirse(Double.parseDouble(coman[0]), Double.parseDouble(coman[1]));
                comdIngresado.appendText(comando);
                break;
            case "sensar":
                comdIngresado.appendText(comando);
                cbRover.getValue().sensar();
                break;
            case "cargar":

                comdIngresado.appendText(comando);
                cbRover.getValue().cargar();
                break;
            default:
                //alerta
                Validaciones.lanzarAlerta("No existe comando");
                break;
        }

    }

    @FXML
    private void cargarRover(ActionEvent event) {
        //  
        // roverChosed.setRectan(recta);

        ImageView rover = null;
        try {
            System.out.println("entra2");

            InputStream input = App.class.getResource(cbRover.getValue().getUrlImagen()).openStream();
            Image img = new Image(input, 100, 100, true, true);
            //   Image img = new Image("rover.jpg", 100, 100, true, true);

            rover = new ImageView(img);
            rover = new ImageView(img);

        } catch (NullPointerException | IOException ex) {
            //        ex.printStackTrace();
            System.out.println("entr3");
            rover = new ImageView();

        }
        System.out.println("4");
        panelExplorar.getChildren().add(rover);
        cbRover.getValue().setImgv(rover);
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

    private boolean limites() {
        double alturaRover = cbRover.getValue().getImgv().getFitHeight();
        double anchoRover = cbRover.getValue().getImgv().getFitWidth();

        if (panelExplorar.getPrefHeight() - alturaRover > alturaRover && panelExplorar.getPrefWidth() - anchoRover > anchoRover) {
            return true;
        } else {
            return false;
        }
    }

}
