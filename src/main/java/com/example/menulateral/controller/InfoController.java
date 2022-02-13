package com.example.menulateral.controller;

import com.example.menulateral.Model.Persona;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;


public class InfoController implements Initializable {
    @FXML private Text text;
    @FXML private ImageView image;

    private Persona p = new Persona();

    public void setText(String texto){
        text.setText(texto);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}