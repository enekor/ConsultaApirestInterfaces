package com.example.menulateral;

import com.example.menulateral.Model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {
    @FXML private Button button;
    @FXML private Text text;
    @FXML private ImageView image;

    private Person p = new Person();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button.setOnMouseClicked(v->{
            p = new Person("Juana","98");

            text.setText("Su nombre es "+p.getNombre()+" y tiene "+p.getEdad());
        });
    }
}