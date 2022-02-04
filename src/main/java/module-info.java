module com.example.menulateral {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.bootstrapicons;
    requires  org.kordamp.ikonli.javafx;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires lombok;

    opens com.example.menulateral to javafx.fxml;
    exports com.example.menulateral;
    exports com.example.menulateral.controller;
    opens com.example.menulateral.controller to javafx.fxml;
}