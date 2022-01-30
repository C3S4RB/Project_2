package com.mycompany.proyectomarte;

import com.mycompany.proyectomarte.modelo.Nasa;
import com.mycompany.proyectomarte.modelo.Crater;
import com.mycompany.proyectomarte.modelo.Rover;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Nasa nasa;
    private static Scene scene;
    private List<Crater> crateres;
    private List<Rover> rovers;
    private List<String> minerales;
    
    /**
     * 
     * @throws IOException lanza una excepcion de tipo IOException
     */
    public void init() throws IOException {
        nasa = new Nasa();
    }
    /**
     * 
     * @param stage es la ventana 
     * @throws IOException lanza una excepcion de tipo IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent vista = loadFXML("VistaInicio");

        stage.setTitle("Proyecto Marte");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("marteIcon.png")));

        scene = new Scene(vista, 1200, 690);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 
     * @param root el nuevo contenedor
     */
    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }
    
    /**
     * 
     * @param fxml es el nombre del archivo fxml
     * @return
     * @throws IOException lanza una excepcion de tipo IOException
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }
    /**
     * 
     * @return 
     */
    public static Nasa getNasa() {
        return nasa;
    }

}
