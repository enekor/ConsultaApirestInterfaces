package com.example.menulateral.controller;

import com.example.menulateral.Model.Intercambio;
import com.example.menulateral.Model.PersonList;
import com.example.menulateral.Model.Persona;
import com.example.menulateral.Model.restmodel.Person;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Data
public class HomeController implements Initializable {

    @FXML private ListView lista;
    @FXML private Button refrescar;
    @FXML private ImageView espera;
    final private ObservableList<Persona> listPerson =  FXCollections.observableArrayList();
    RestToModel rest = new RestToModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        espera.setImage(new Image("https://www.freeiconspng.com/thumbs/stop-sign-png/stop-sign-png-18.png"));
        refrescar.setOnMouseClicked(v->{
            System.out.println(lista.isVisible());
            lista.setVisible(false);
            System.out.println(lista.isVisible());
            refrescar();
            lista.setVisible(true);
        });
    }

    private void refrescar(){
        PersonList.getInstance().clearList();

        while(PersonList.getInstance().getPersons().size()<20){
            try {
                PersonList.getInstance().addPerson(rest.getPerson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setTable();
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