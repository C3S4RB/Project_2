/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectomarte;

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
    private TextField txtFechaFin;
    @FXML
    private TextField txtFechaInicio;
    @FXML
    private TextField txtMineral;
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
    private void buscar(ContextMenuEvent event) {
        /*
        //metodo que busque las fechas y minerales...
        //obtenemos el texto pasado por 
        //creo DataTime.valueOf(this.txtFechaInicio.getText());
        String fechaInicio = this.txtFechaInicio.getText();
        String fechaFin = this.txtFechaFin.getText();
        String mineral = this.txtMineral.getText();
        
        //Para agregar las lineas del registro
        ArrayList<> registro = new ArrayList<>();
        //Creo los registros
        
        //añado los registros al arrylist registro
        for(r : registro){
            this.registros.add(r);
        }
        this.tableView.setItems(registros);
        */
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
