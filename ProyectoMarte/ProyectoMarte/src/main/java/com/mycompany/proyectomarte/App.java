package com.mycompany.proyectomarte;

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
    List<Crater> crateres;
    List<Rover> rovers;
    List<String> minerales;

    public void init() throws IOException {
        nasa = new Nasa();
    }

    @Override
    //55555555
    public void start(Stage stage) throws IOException {
        Parent vista = loadFXML("VistaInicio");

        stage.setTitle("Proyecto Marte");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("marteIcon.png")));

        scene = new Scene(vista, 1200, 690);
        stage.setScene(scene);
        stage.show();
    }


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
