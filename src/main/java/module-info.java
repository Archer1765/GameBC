module com.example.gamebc {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.gamebc to javafx.fxml;
    exports com.example.gamebc;
}