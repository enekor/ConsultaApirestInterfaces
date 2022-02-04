package com.example.menulateral.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lombok.Data;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class HomeController implements Initializable {

    @FXML private Button refrescar;
    @FXML private ListView lista;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        refrescar.setOnMouseClicked(x->{

        });
    }


}
