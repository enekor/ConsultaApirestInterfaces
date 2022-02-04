package com.example.menulateral.controller;

import com.example.menulateral.Model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class InfoController implements Initializable {
    @FXML private Text text;
    @FXML private ImageView image,imagen;

    private Person p = new Person();

    public void setText(String texto){
        text.setText(texto);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}