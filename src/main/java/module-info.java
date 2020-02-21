module com.eugenep {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens com.eugenep.controller to javafx.fxml;
    exports com.eugenep;
}