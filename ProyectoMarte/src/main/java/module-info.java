module com.mycompany.proyectomarte {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectomarte to javafx.fxml;
    exports com.mycompany.proyectomarte;
    
    opens com.mycompany.proyectomarte.data to javafx.fxml;
    exports com.mycompany.proyectomarte.data;
    
    opens com.mycompany.proyectomarte.modelo to javafx.fxml;
    exports com.mycompany.proyectomarte.modelo;
}
