package com.example.menulateral.controller;

import com.example.menulateral.Model.Intercambio;
import com.example.menulateral.Model.PersonList;
import com.example.menulateral.Model.Persona;
import com.example.menulateral.rest.RestToModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import lombok.Data;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class HomeController implements Initializable {

    @FXML private Button refrescar;
    @FXML private ListView lista;
    final ObservableList<Persona> listPerson =  FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        refrescar.setOnMouseClicked(x->{
            refrescar();
            setTable();
        });
    }

    private void refrescar(){
        RestToModel rest = new RestToModel();
        for (int i = 0;i<3;i++){
            try {
                rest.setPersona(rest.getPerson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setTable(){
        listPerson.addAll(PersonList.getInstance().getPersons());
        lista.setItems(listPerson);

        lista.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Intercambio.getInstance().setPersona((Persona) lista.getSelectionModel().getSelectedItem());
            }
        });
    }
}
