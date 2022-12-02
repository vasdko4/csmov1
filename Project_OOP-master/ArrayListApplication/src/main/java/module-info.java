module com.example.arraylistapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.arraylistapplication to javafx.fxml;
    exports com.example.arraylistapplication;
}