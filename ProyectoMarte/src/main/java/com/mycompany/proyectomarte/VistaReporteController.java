/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Validaciones;
import static com.mycompany.proyectomarte.modelo.Validaciones.validarFecha;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ramses
 */
public class VistaReporteController implements Initializable {

    @FXML
    private TableColumn columnaFecha;
    @FXML
    private TableColumn columnaNombreCrater;
    @FXML
    private TableColumn columnaMinerales;
    @FXML
    private TableView<String> tableView;

    //? va la clase donde esta el registro
    private ObservableList<?> registros;
    @FXML
    private TextField txtMineral;
    @FXML
    private TextField txtFechaIncio;
    @FXML
    private TextField txtFechaFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registros = FXCollections.observableArrayList();
        //a,b,c, van las variables que se van a referenciar
        this.columnaFecha.setCellValueFactory(new PropertyValueFactory<>("a"));
        this.columnaNombreCrater.setCellValueFactory(new PropertyValueFactory<>("b"));
        this.columnaMinerales.setCellValueFactory(new PropertyValueFactory<>("c"));
    }

    @FXML
    private void buscar(MouseEvent event) {
        try {
            //obtenemos los textos
            String mineral = txtMineral.getText();

            String fechaI = txtFechaIncio.getText();
            String[] dateI = fechaI.split("/");

            String fechaF = txtFechaFin.getText();
            String[] dateF = fechaF.split("/");
            
            //Validamos que los parametros esten llenos 
            //Si alguno de los textos estan vacios muestra una alerta            
            if (fechaI.isEmpty() || fechaF.isEmpty() || mineral.isEmpty()) {
                if (fechaI.isEmpty() && fechaF.isEmpty() && mineral.isEmpty()) {
                    Validaciones.lanzarAlerta("Los contenidos no pueden estar vacios.");
                } else if (fechaI.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido de ficha final no puede estar vacio.");
                } else if (fechaF.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido de ficha final no puede estar vacio.");
                } else if (mineral.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido del mineral no puede estar vacio.");
                }
                
                //Una vez que estan ingresados los 3 parametros 
                //Validamos que estos sean correctos
                //Si una de las fechas NO tiene el formato correcto
                //usamos el metodo validarFecha el cual se encuentra en la clase Validaciones            
            } else if (!validarFecha(fechaI) || !validarFecha(fechaF)) {
                //si ambas fechas tienen mal el formato
                if (!validarFecha(fechaI) && !validarFecha(fechaF)) {
                    Validaciones.lanzarAlerta("Formato de la fecha inicio y fecha fin son incorrecto.");
                } else if (!validarFecha(fechaI)) {
                    Validaciones.lanzarAlerta("Formato de la fecha inicio es incorrecto.");
                } else if (!validarFecha(fechaF)) {
                    Validaciones.lanzarAlerta("Formato de la fecha fin es incorrecto.");
                }
         
            //Validamos que el nombre del mineral no es valido
            //usamos el metodo 
            /*
            } else if(!validarMineral(mineral)){                 
                Validaciones.lanzarAlerta("Nombre del mineral incorrecto");
            */
            
            //si los textos no estan vacios y esta todo correcto
            } else {
                LocalDate fechaInicio = LocalDate.of(Integer.valueOf(dateI[0]), Integer.valueOf(dateI[1]), Integer.valueOf(dateI[3]));
                LocalDate fechaFin = LocalDate.of(Integer.valueOf(dateF[0]), Integer.valueOf(dateF[1]), Integer.valueOf(dateF[3]));

                //metodo que busque las fechas y minerales...
                /*
                
                //Para agregar las lineas del registro
                ArrayList<> registro = new ArrayList<>();
                //Creo los registros

                //añado los registros al arrylist registro
                for (r  : registro) {
                 this.registros.add(r);
                }
                this.tableView.setItems(registros);
                 */
            }
        } catch (NullPointerException ex) {
            //Alerta de tipo error
            Alert alert = new Alert(AlertType.ERROR);
            //El mensaje del contenido
            alert.setContentText("El contenido no puede estar vacio");
            //Muestra la alerta
            alert.showAndWait();
        }
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
}
