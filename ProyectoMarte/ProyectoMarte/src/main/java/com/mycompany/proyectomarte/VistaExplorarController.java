/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.CONSTANTES;
import com.mycompany.proyectomarte.data.CraterData;
import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Rover_Eolico;
import com.mycompany.proyectomarte.modelo.Validaciones;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

    private static List<Rover> rovers = Nasa.getRovers();

    public static List<Rover> getRovers() {
        return rovers;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRover.getItems().addAll(rovers);
        List<Crater> crateresF = CraterData.pintar(CraterData.listaSensados(), Nasa.getCrateres());
        for (Crater crater : crateresF) {
            Label l = new Label(crater.getNombrecrater());
            l.setTextFill(Color.WHITE);
            st = new StackPane();
            double d = 2 * crater.getCircle().getRadius();
            st.getChildren().addAll(crater.getCircle(), l);
            panelExplorar.getChildren().addAll(st);
            st.setLayoutX(crater.getCircle().getCenterX());
            st.setLayoutY(crater.getCircle().getCenterY());

        }
    }

    /*public static List<Rover> getRovers() {
        return rovers;
    }*/
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
            roverImg.setFitHeight(roverImg.getImage().getHeight());
            roverImg.setFitWidth(roverImg.getImage().getWidth());
            roverImg.setLayoutX(rover.getUbicacion().getLongitud());
            roverImg.setLayoutY(rover.getUbicacion().getLatitud());
            roverImg.setRotate(rover.getGrados());
            
        } catch (NullPointerException | IOException ex) {
            roverImg = new ImageView();
        }

        /*  
         if( rover instanceof Rover_Eolico ){
         
            try (BufferedWriter outputStream
                        = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "rovers.txt", false))) {
                outputStream.newLine();
                    outputStream.write("chapie"+","+String.valueOf(rover.getUbicacion().getLongitud())+","+String.valueOf(rover.getUbicacion().getLatitud())+","+"eolico");
                    //outputStream.newLine();
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException." + e.getMessage());
                }
            }else{
                     try (BufferedWriter outputStream
                        = new BufferedWriter(new FileWriter(CONSTANTES.ARCHIVOS + "rovers.txt", false))) {

                    outputStream.write("wallie"+","+String.valueOf(rover.getUbicacion().getLongitud())+","+String.valueOf(rover.getUbicacion().getLatitud())+","+"solar");
                    //outputStream.newLine();
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException." + e.getMessage());
                }
    
         
         
         
         }
        
        
         */
        panelExplorar.getChildren().add(roverImg);
        rover.setImgv(roverImg);

    }

    @FXML
    private void recibirComando(ActionEvent event) {
        String comando = comandoTxt.getText().replace(" ", "").toLowerCase();
        String[] comand = comando.split(":");
        switch (comand[0]) {
            case "avanzar":
                //  if(limites()){
                //rover.descargar()

                if (rover.getBateria() > 0) {
                    comdIngresado.appendText("\n" + comando);
                    rover.avanzar();
                    rover.descargar();
                } else {
                    Validaciones.lanzarAlertaInfo("Batería baja: " + rover.getBateria() + "%" + "\nCargar batería urgente!!!");

                }

                //}//else{
                // rover.getImgv().setLayoutX();
                //rover.getImgv().setLayoutY(roverImg.getLayoutY()-55);
                //}
                break;
            case "girar":
                try {
                comdIngresado.appendText("\n" + comando);
                rover.girar(Double.parseDouble(comand[1]) + rover.getImgv().getRotate());

            } catch (NumberFormatException e) {
                Validaciones.lanzarAlerta("El dato ingresado no es un dígito");
            }

            break;
            case "dirigirse":
                     try {
                comdIngresado.appendText("\n" + comando);
                String[] xy = comand[1].split(",");
                rover.setUbicacionx(Double.parseDouble(xy[0]));
                rover.setUbicaciony(Double.parseDouble(xy[1]));
                if (rover.getBateria() > 0) {
                    comdIngresado.appendText("\n" + comando);
                    rover.dirigirse(rover.getUbicacionx(), rover.getUbicaciony());

                    //  rover.descargar();
                } else {
                    Validaciones.lanzarAlertaInfo("Batería baja: " + rover.getBateria() + "%" + "\nCargar batería urgente!!!");

                }

            } catch (NumberFormatException e) {
                Validaciones.lanzarAlerta("El dato ingresado no es un dígito");
            }

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

    /* private boolean limites() {
        double y = rover.getImgv().getLayoutY();
        double x = rover.getImgv().getLayoutX();
        if ((panelExplorar.getPrefHeight()-50   > y  ||  y>0   )&& (panelExplorar.getPrefWidth() -50 >= x || x>0 )) {
            return true;
        } else {
            return false;
            
            
        }
    }*/
}
