/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.data.RegistroData;
import com.mycompany.proyectomarte.modelo.Registro;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Validaciones;
import static com.mycompany.proyectomarte.modelo.Validaciones.validarFecha;
import static com.mycompany.proyectomarte.modelo.Validaciones.validarMineral;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
public class VistaReporteController implements Initializable {

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

    private ObservableList<Registro> registros;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Registro> registro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registro = RegistroData.cargarRegistros();
        registros = FXCollections.observableArrayList();
        columnaFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        columnaNombreCrater.setCellValueFactory(new PropertyValueFactory("crater"));
        columnaMinerales.setCellValueFactory(new PropertyValueFactory("mineralesE"));
    }
    
    /**
     * 
     * @param event evento del tipo mouseClicked 
     */
    @FXML
    private void buscar(MouseEvent event) {
        try {
            //obtenemos los textos            
            String mineral = txtMineral.getText().trim();
            String fechaI = txtFechaIncio.getText().trim();
            String fechaF = txtFechaFin.getText().trim();

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

                        registrovalido(fechaInicio, fechaFin, mineral);

                        if (registros.isEmpty()) {
                            Validaciones.lanzarAlertaInfo("No existen regitros en ese intervalo de fechas.");
                        }
                        //Si registros esta lleno lo añade al tableView
                        tableView.setItems(registros);
                    }
                }
            }
        } catch (NullPointerException ex) {
            Validaciones.lanzarAlerta("El contenido no puede estar vacio.");
        }
    }
    
    /**
     * 
     * @param fechaInicio es la fecha de inicio que ingresa el usuario 
     * @param fechaFin es la fecha fin que ingresa el usuario 
     * @param mineral son los minerales que ingresa el usuario
     */
    private void registrovalido(LocalDate fechaInicio, LocalDate fechaFin, String mineral) {        
        Collections.sort(registro);
        for (Registro r : registro) {
            if ((r.getFecha().isAfter(fechaInicio)) && (r.getFecha().isBefore(fechaFin)) || ((r.getFecha().isEqual(fechaInicio)) || r.getFecha().isEqual(fechaFin))) {
                for (String m : r.getMineralesEncontrados()) {
                    String[] min = m.split(",");
                    for (String mi : min) {
                        if (mi.equals(Validaciones.capital(mineral))) {
                            registros.add(r);
                            break;
                        }
                    }
                }
            }
        }
    }
    /**
     * 
     * @param event evento del tipo mouseClickedevento del tipo mouseClicked
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
