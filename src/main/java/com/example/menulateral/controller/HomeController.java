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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Data;
import java.net.URL;
import java.util.ResourceBundle;

@Data
public class HomeController implements Initializable {

    @FXML private ListView lista;
    @FXML private Button refrescar;
    @FXML private ImageView espera;
    final private ObservableList<Persona> listPerson =  FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refrescar.setOnMouseClicked(v->{
            espera.setVisible(true);
            try {
                Thread.sleep(45);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            espera.setImage(new Image("https://www.freeiconspng.com/thumbs/stop-sign-png/stop-sign-png-18.png"));
            refrescar();
            setTable();
            espera.setVisible(false);
        });
    }

    private void refrescar(){
        CargaDatos cd = new CargaDatos();
        Thread t = new Thread(cd);
        t.start();
        while(t.isAlive()){
            espera.setVisible(true);
        }
    }

    private void setTable(){
        if (listPerson.size()==20){
            listPerson.clear();
        }
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

class CargaDatos implements Runnable {

    RestToModel rest = new RestToModel();

    @Override
    public void run() {
        PersonList.getInstance().clearList();
        while(PersonList.getInstance().getPersons().size()<20){
            try {
                rest.setPersona(rest.getPerson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}