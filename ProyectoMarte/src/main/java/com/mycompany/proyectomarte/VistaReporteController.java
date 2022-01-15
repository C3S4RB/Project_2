/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Registro;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Validaciones;
import static com.mycompany.proyectomarte.modelo.Validaciones.validarFecha;
import static com.mycompany.proyectomarte.modelo.Validaciones.validarMineral;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ramses
 */
public class VistaReporteController implements Initializable {//, Comparable<Reporte>{

    @FXML
    private TableColumn<Registro, LocalDate> columnaFecha;
    @FXML
    private TableColumn<Registro, Crater> columnaNombreCrater;
    @FXML
    private TableColumn<Registro, String> columnaMinerales;
    @FXML
    private TableView<Registro> tableView;
    @FXML
    private TextField txtMineral;
    @FXML
    private TextField txtFechaIncio;
    @FXML
    private TextField txtFechaFin;

    //En ? va la clase donde esta el registro
    private ObservableList<Registro> registros;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registros = FXCollections.observableArrayList();
        columnaFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        columnaNombreCrater.setCellValueFactory(new PropertyValueFactory("crater"));
        columnaMinerales.setCellValueFactory(new PropertyValueFactory("minerales"));
    }

    @FXML
    private void buscar(MouseEvent event) {
        try {
            //obtenemos los textos            
            String mineral = txtMineral.getText();
            String fechaI = txtFechaIncio.getText();
            String fechaF = txtFechaFin.getText();

            //Validamos que los parametros esten llenos 
            //Si alguno de los textos estan vacios muestra una alerta            
            if (fechaI.isEmpty() || fechaF.isEmpty() || mineral.isEmpty()) {
                if (fechaI.isEmpty() && fechaF.isEmpty() && mineral.isEmpty()) {
                    Validaciones.lanzarAlerta("Los contenidos no pueden estar vacios.");
                } else if (fechaI.isEmpty() && fechaF.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido de las fechas no pueden estar vacios.");
                } else if (fechaI.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido de fecha inicio no puede estar vacio.");
                } else if (fechaF.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido de fecha fin no puede estar vacio.");
                } else if (mineral.isEmpty()) {
                    Validaciones.lanzarAlerta("El contenido del mineral no puede estar vacio.");
                }
                //Una vez que estan ingresados los 3 parametros 
                //Validamos que estos sean correctos        
            } else {
                //usamos el metodo validarFecha el cual se encuentra en la clase Validaciones    
                if (!validarFecha(fechaI) && !validarFecha(fechaF) && !validarMineral(Validaciones.capital(mineral))) {
                    Validaciones.lanzarAlerta("Los tres datos ingresados son incorrecto.");
                    //Si una de las fechas NO tiene el formato correcto
                } else {
                    if (!validarFecha(fechaI) || !validarFecha(fechaF)) {
                        //si ambas fechas tienen mal el formato
                        if (!validarFecha(fechaI) && !validarFecha(fechaF)) {
                            Validaciones.lanzarAlerta("Formato de la fecha inicio y fecha fin son incorrecto.");
                        } else if (!validarFecha(fechaI)) {
                            Validaciones.lanzarAlerta("Formato de la fecha inicio es incorrecto.");
                        } else if (!validarFecha(fechaF)) {
                            Validaciones.lanzarAlerta("Formato de la fecha fin es incorrecto.");
                        }
                        //Si el fomato de las fechas son correctos
                    } else if (validarFecha(fechaI) && validarFecha(fechaF)) {
                        //Para crear el local date se sigue el formato año/mes/dia
                        String[] dateI = fechaI.split("-");
                        String[] dateF = fechaF.split("-");
                        System.out.println("Hola pta");
                        fechaInicio = LocalDate.of(Integer.valueOf(dateI[2]), Integer.valueOf(dateI[1]), Integer.valueOf(dateI[0]));
                        fechaFin = LocalDate.of(Integer.valueOf(dateF[2]), Integer.valueOf(dateF[1]), Integer.valueOf(dateF[0]));
                        //Verificamos que la fecha Inicio este antes que la fecha fin
                        if (fechaFin.isBefore(fechaInicio)) {
                            Validaciones.lanzarAlerta("La fecha fin no puede estar antes que la fecha inicio.");
                        } else if (fechaFin.isEqual(fechaInicio)) {
                            Validaciones.lanzarAlerta("La fecha inicio y fin no pueden ser iguales.");
                        }
                    }
                    if (!validarMineral(Validaciones.capital(mineral))) {
                        Validaciones.lanzarAlerta("Nombre del mineral incorrecto.");

                        //Si los textos no estan vacios y esta todo correcto 
                        //Mostramos en la tabla
                    } else if (validarFecha(fechaI) && validarFecha(fechaF) && !fechaFin.isBefore(fechaInicio) && !fechaFin.isEqual(fechaInicio) && validarMineral(mineral)) {
                        tableView.getItems().clear();
                        //Mensaje que diga, procesando informacion, pilas!!!!!!!11

                        //Creo los registros
                        /*
                        List<Registro> rcf = registroCumplenFecha(fechaInicio, fechaFin, registro);
                        List<Registro> registroFinal = registroFinal(rcf, mineral);
                        for(Registro rf : registroFinal){                            
                            //Creo el registro
                            Registro re = new Registro(rf.getFecha(), rf.getCrater(), rf.getMineralesEncontrados());                         
                            //registros.add(re);                           
                        }
                        */
                        tableView.setItems(registros);

                        //Validaciones.lanzarAlerta("Todo bien :v");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        //Mostramos un mensaje con el contenido:
                        alert.setContentText("Todo bien :v");
                        //Muestra la alerta
                        alert.showAndWait();
                    }
                }
            }
        } catch (NullPointerException ex) {
            Validaciones.lanzarAlerta("El contenido no puede estar vacio");
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
