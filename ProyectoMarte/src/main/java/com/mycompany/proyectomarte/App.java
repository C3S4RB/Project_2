package com.mycompany.proyectomarte;


import com.mycompany.proyectomarte.data.MineralData;
import com.mycompany.proyectomarte.data.RegistroData;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Registro;
import com.mycompany.proyectomarte.modelo.Rover;
import com.mycompany.proyectomarte.modelo.Validaciones;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Nasa nasa;
    private static Scene scene;
    List<Crater> crateres;
    List<Rover> rovers;
    List<String> minerales;

    public void init() throws IOException {
        nasa = new Nasa();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent vista = loadFXML("VistaInicio");

        stage.setTitle("Proyecto Marte");              
        stage.getIcons().add(new Image(App.class.getResourceAsStream("marteIcon.png")));        

        scene = new Scene(vista, 1200, 690);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        /*
        List<Crater> craterValidos = Validaciones.crateresCumplen(Nasa.getCrateres(), "Aluminio");
        List<String> registros = new ArrayList<>();
        List<String> mineralesValidos = Validaciones.mineralesCraterCumplen(c);        
        for (Crater c : craterValidos) {           
            String mineralesValidos = Validaciones.mineralesCraterCumplen(c);
            
            //Nombre de los crateres validos
            registros.add(c.getNombrecrater());
            
            System.out.println("Crater: "+c.getNombrecrater());
            System.out.println("Minerales: "+mineralesValidos);
            //System.out.println(LocalDate.now().isAfter(LocalDate.of(2023, 01, 01)));
            //Registro r = new Registro(LocalDate.now(), c.getNombrecrater(), mineralesValidos);
            //Recorre los minerales
            
            for (String m : mineralesValidos) {
                //System.out.println(m);
                //{Aluminio,oro ,plata}
                //Registro r = new Registro("0", c.getNombrecrater(), m);
                //añado los registros al arraylist registro                
            }            
        }
        */     
        //System.out.println("Registros: "+registros);
        //LocalDate fecha = LocalDate.of(2021,01,12);
        //System.out.println(fecha);        
        System.out.println(LocalDate.now());
       
        List<Registro> r = RegistroData.leerRegistros();
        System.out.println(r);
        
        Collections.sort(r);
        System.out.println(r);
    }

    /**
     * Cambia el contenedor raiz de la escena por el pasado como parametro
     *
     * @param root : contenedor raiz
     * @throws IOException
     */
    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Nasa getNasa() {
        return nasa;
    }

}
