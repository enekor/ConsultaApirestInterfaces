module com.example.menulateral {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.bootstrapicons;
    requires  org.kordamp.ikonli.javafx;

    opens com.example.menulateral to javafx.fxml;
    exports com.example.menulateral;
}