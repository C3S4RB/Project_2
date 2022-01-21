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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author cebor
 */
public class VistaExplorarController implements Initializable {

    @FXML
    private Pane panelExplorar;
    @FXML
    private ComboBox<Rover> cbRover;
    @FXML
    private TextField comandoTxt;
    @FXML
    private TextArea comdIngresado;

    private StackPane st;
    private Rover rover;
    private ImageView roverImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        List<Rover> rovers = RoverData.leerRovers();

        cbRover.getItems().addAll(rovers);

        for (Crater crater : Nasa.getCrateres()) {

            Label l = new Label(crater.getNombrecrater());
            st = new StackPane();
            double d = 2 * crater.getCircle().getRadius();
            if (panelExplorar.getPrefHeight() - d > crater.getUbicacion().getLongitud() && panelExplorar.getPrefWidth() - d > crater.getUbicacion().getLatitud()) {
                st.getChildren().addAll(crater.getCircle(), l);
                panelExplorar.getChildren().addAll(st);
                st.setLayoutX(crater.getUbicacion().getLatitud());
                st.setLayoutY(crater.getUbicacion().getLongitud());
                crater.setCircle(crater.getCircle());
            }

        }

    }

    @FXML
    private void cargarRover(ActionEvent event) {
        rover = cbRover.getValue();
        System.out.println(rover);
        if (roverImg != null) {

            panelExplorar.getChildren().remove(roverImg);
        }

        try {

            InputStream input = App.class.getResource(rover.getUrlImagen()).openStream();
            Image img = new Image(input, 50, 50, true, true);
            roverImg = new ImageView(img);
            roverImg.setLayoutX(rover.getUbicacion().getLongitud());
            roverImg.setLayoutY(rover.getUbicacion().getLatitud());
            roverImg.setRotate(rover.getGrados());
        } catch (NullPointerException | IOException ex) {
            roverImg = new ImageView();
        }

        panelExplorar.getChildren().add(roverImg);
        rover.setImgv(roverImg);

    }

    @FXML
    private void recibirComando(ActionEvent event) {
        String comando = comandoTxt.getText().replace(" ", "").toLowerCase();//dirigirase:20,30
        String[] comand = comando.split(":"); //girar:90 
        switch (comand[0]) {
            case "avanzar":
                if(limites()){
                comdIngresado.appendText("\n" + comando);
                System.out.println("si entro avanzar");
                rover.avanzar();
                //roverImg.
                }
                break;
            case "girar":
                comdIngresado.appendText("\n" + comando);
                // roverImg.setRotate(rover.getGrados());
                //roverImg.setRotate(Double.parseDouble(comand[1]) + roverImg.getRotate());
                //rover.getUbicacion().setLongitud(roverImg.getLayoutX());
                 //rover.getUbicacion().setLatitud(roverImg.getLayoutY());
                 //rover.setGrados();
                
                        //ion(ubicacion);
               rover.girar(Double.parseDouble(comand[1]) + rover.getImgv().getRotate());
                break;
            case "dirigirse":
                comdIngresado.appendText("\n" + comando);
                String[] xy = comand[1].split(",");
                rover.dirigirse(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));
                break;
            case "sensar":
                comdIngresado.appendText("\n" + comando);
                rover.sensar();
                break;
            case "cargar":
                comdIngresado.appendText("\n" + comando);
                rover.cargar();
                break;
            default:
                Validaciones.lanzarAlerta("No existe comando");
                break;
        }

    }

    @FXML
    private void regresar(MouseEvent event) {

        Parent root;
        try {
            root = App.loadFXML("VistaInicio");
            App.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private boolean limites() {
        //double h = cbRover.getValue().getUbicacion().getLatitud();
        // double x = cbRover.getValue().getUbicacion().getLongitud();
        double y = rover.getImgv().getLayoutY();
        double x = rover.getImgv().getLayoutX();
        System.out.println(panelExplorar.getPrefHeight() + "+" + panelExplorar.getPrefWidth());
        System.out.println(y + "+" + x);
        if ((panelExplorar.getPrefHeight()-50   > y  ||  y>0   )&& (panelExplorar.getPrefWidth() -50 >= x || x>0 )) {
            return true;
        } else {
            return false;
            
        }
    }

}