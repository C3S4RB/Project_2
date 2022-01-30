/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.RoverData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Ubicacion;
import com.mycompany.proyectomarte.modelo.Validaciones;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class 
 * Representa el controlador del fxml VistaPlanificar.fxml  en la cual se planifica la ruta optima
 *
 * @author kevin
 */
public class VistaPlanificarController implements Initializable {

    Ubicacion ubicacionMenor;

    Crater craterMenor;

    ArrayList<Crater> rutaOptima;

    @FXML
    private TextField txtCrateres;
    @FXML
    private ComboBox<Rover> cbRovers;

    private ObservableList<Crater> ruta;
    @FXML
    private TableView<Crater> tbvOptima;
    @FXML
    private TableColumn<Crater, String> columnaRutaOptima;
    double distanciaMayor=Double.MAX_VALUE;
    
    Rover rover1;
    Rover rover2;
    
    /**
     * Initializes the controller class 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Rover> rovers = RoverData.cargarRovers();
        cbRovers.getItems().addAll(rovers);
        ruta = FXCollections.observableArrayList();
        columnaRutaOptima.setCellValueFactory(new PropertyValueFactory<>("nombrecrater"));
        List<Rover> roversExplorar = RoverData.cargarRovers();
        rover1 = roversExplorar.get(0);
        rover2 = roversExplorar.get(1);
        
        
    }
    /**
     * 
     * @param craterEtiquetador crater con la menor distancia
     */
    public void rutasOptimas(Crater craterEtiquetador) {
        rutaOptima.add(craterEtiquetador);
    }
    
    /**
     * 
     * @param crateresCumplen lista de crateres validados
     * @param roverExplorar es el rover que selecciona el usuario
     * @return 
     */
    public Crater darEtiquetaUbicacionMenor(List<Crater> crateresCumplen, Rover roverExplorar) {

        for (Crater c : crateresCumplen) {
            double distanciaMenor = Ubicacion.calcularDistancia(c.getUbicacion(), roverExplorar.getUbicacion());
            if (distanciaMenor <= distanciaMayor) {         
                distanciaMayor = Ubicacion.calcularDistancia(c.getUbicacion(), roverExplorar.getUbicacion());
                craterMenor = c;
            }
        }
        distanciaMayor=Double.MAX_VALUE;
        roverExplorar.setUbicacion(craterMenor.getUbicacion());
        return craterMenor;
    }
    
    /**
     * 
     * @param event evento del tipo mouseClicked
     */
    @FXML
    private void mostarRuta(MouseEvent event) {
        
        rutaOptima = new ArrayList<>();
        tbvOptima.getItems().clear();
        try {
            String ingresados = txtCrateres.getText();
            Rover roverSeleccionado = cbRovers.getValue();
            //Si estan vacios muestran alertas
            if (ingresados.isEmpty() || roverSeleccionado == null) {
                if (ingresados.isEmpty() && (roverSeleccionado == null)) {
                    Validaciones.lanzarAlerta("Ingrese los nombres de los crateres y seleccione un rover");
                } else if (ingresados.isEmpty()) {
                    Validaciones.lanzarAlerta("Los nombres de los crateres no pueden estar vacios.");
                } else if (roverSeleccionado == null) {
                    Validaciones.lanzarAlerta("Debe selecionar un rover");
                }
            //si no estan vacios seguimos
            } else {
               
                List<Crater> crateresCumplen = Validaciones.validarCrateres(ingresados);
                roverSeleccionado = cbRovers.getValue();
                
                if(rover1.equals(roverSeleccionado)){
                    roverSeleccionado.setUbicacion(rover1.getUbicacion());
                }else{
                    roverSeleccionado.setUbicacion(rover2.getUbicacion());
                }

                
                while (!(crateresCumplen.isEmpty())) {
                    Crater craterEtiquetado = darEtiquetaUbicacionMenor(crateresCumplen, roverSeleccionado);
                    rutasOptimas(craterEtiquetado);
                    crateresCumplen.remove(craterEtiquetado);
                }
                

                for (Crater crater : rutaOptima) {
                    ruta.add(crater);
                }
                tbvOptima.setItems(ruta);
            }

        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * 
     * @param event evento del tipo mouseClicked
     */
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
}