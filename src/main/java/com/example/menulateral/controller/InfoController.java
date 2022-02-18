package com.example.menulateral.controller;

import com.example.menulateral.Model.Intercambio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;


public class InfoController implements Initializable {
    @FXML private Text text;
    @FXML private ImageView image;

    public void initInfo(){
        System.out.println("hola");
        text.setText(Intercambio.getInstance().getPersona().toString2());
        System.out.println(Intercambio.getInstance().getPersona().getPicture());
        image.setImage(new Image(Intercambio.getInstance().getPersona().getPicture()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}