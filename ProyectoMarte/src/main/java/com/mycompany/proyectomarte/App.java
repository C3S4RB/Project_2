package com.mycompany.proyectomarte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Nasa nasa;
    private static Scene scene;

   
   public void init() throws IOException{
       nasa = new Nasa();
   }
   
    @Override
    public void start(Stage stage) throws IOException {
        Parent vista = loadFXML("VistaInicio");
        stage.getIcons().add(new Image(" marteIcon.png "));
         stage.setTitle("Proyecto Marte");
        scene = new Scene(vista, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Cambia el contenedor raiz de la escena por el pasado como parametro
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
    
    public static Nasa getNasa(){
        return nasa;
    }

}